package com.listaSpesa.listaspesa.service;

import com.listaSpesa.listaspesa.entity.Articolo;
import com.listaSpesa.listaspesa.entity.ListaSpesa;
import com.listaSpesa.listaspesa.repository.ArticoloRepository;
import com.listaSpesa.listaspesa.repository.ListaSpesaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ListaSpesaService {

    private final ListaSpesaRepository listaSpesaRepo;
    private final ArticoloRepository articoloRepository;

    public List<ListaSpesa> getAllListeSpesa() {
        return listaSpesaRepo.findAll();
    }

    public void addListaSpesa(List<Articolo> entities) throws MalformedURLException {

        ListaSpesa res = new ListaSpesa();
        res.setNElementi(res.getNElementi() + entities.size());
        res = listaSpesaRepo.save(res); // Salvo in DB la lista settando l'ID autogenerato;

        // setto qui, prima di salvare gli articoli in DB, gli idLista di tutti gli articoli
        List<Articolo> tmp = entities;
        for (var e : tmp) {
            e.setListaSpesa(res);
        }

        articoloRepository.saveAll(entities); // Salvo in DB la gli articoli settando l'ID autogenerato;
        listaSpesaRepo.save(res);
    }

    public void inserisciArticoliInLista(int idLista, List<Articolo> entries) {
        ListaSpesa res = listaSpesaRepo.findListaSpesaByIdLista(idLista);
        res.setNElementi(res.getNElementi() + entries.size());

        for (var articolo : entries) {
            articolo.setListaSpesa(res);
            articoloRepository.save(articolo);
        }

        listaSpesaRepo.save(res);
    }
}
