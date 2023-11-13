package com.listaSpesa.listaspesa.service;

import com.listaSpesa.listaspesa.dto.InventarioRequest;
import com.listaSpesa.listaspesa.entity.ArticoloMarket;
import com.listaSpesa.listaspesa.entity.Market;
import com.listaSpesa.listaspesa.repository.ArticoloMarketRepository;
import com.listaSpesa.listaspesa.repository.MarketRepository;
import com.listaSpesa.listaspesa.utils.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MarketService {

    private final MarketRepository marketRepository;
    private final ArticoloMarketRepository articoloMarketRepository;

    public GenericResponse<Market> getAllMarket() {
        return new GenericResponse<>(marketRepository.findAll(), false, null);
    }

    public GenericResponse<Market> insertMarket(List<Market> entries) {
        try {
            return new GenericResponse<>(marketRepository.saveAll(entries), false, null);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("insertMarket() error: " + e.getMessage());
        }
    }

    public GenericResponse<Market> setInventarioToMarket(int idMarket, InventarioRequest entry) {
        Optional<Market> market = marketRepository.findById(idMarket);

        if(market.isEmpty()) {
            throw new IllegalStateException("insertInventarioToMarket() error: Market non trovato!");
        }

        List<ArticoloMarket> tmp = articoloMarketRepository.saveAll(entry.getInventario());
        market.get().setInventario(tmp);

        return new GenericResponse<>(List.of(marketRepository.save(market.get())), false, null);
    }


}
