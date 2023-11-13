package com.listaSpesa.listaspesa.controller;

import com.listaSpesa.listaspesa.dto.InventarioRequest;
import com.listaSpesa.listaspesa.entity.Market;
import com.listaSpesa.listaspesa.service.MarketService;
import com.listaSpesa.listaspesa.utils.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/market")
public class MarketController {

    private final MarketService marketService;

    @GetMapping
    public ResponseEntity<GenericResponse<Market>> getAll() {
        return ResponseEntity.ok(marketService.getAllMarket());
    }

    @PostMapping
    public ResponseEntity<GenericResponse<Market>> insertMarket(@RequestBody List<Market> entries) {
        return ResponseEntity.ok(marketService.insertMarket(entries));
    }

    @PostMapping("/{id_market}")
    public ResponseEntity<GenericResponse<Market>> setInventarioToMarket(
            @PathVariable int id_market, @RequestBody InventarioRequest entry) {
        return ResponseEntity.ok(marketService.setInventarioToMarket(id_market, entry));
    }
}
