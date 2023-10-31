package com.listaSpesa.listaspesa.service;

import com.listaSpesa.listaspesa.entity.Articolo;
import com.listaSpesa.listaspesa.repository.ArticoloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticoloService {

    private final ArticoloRepository repo;

    public void updateArticolo(int idLista, int idArticolo, Articolo entry) {
        Articolo res = repo.findByIdArticoloAndListaSpesa_IdLista(idArticolo, idLista);
        res.setNomeArticolo(entry.getNomeArticolo());
        repo.save(res);
    }

    public List<Articolo> findArticoliByListaSpesa(int idL) {
        return repo.findByListaSpesaIdLista(idL);
    }

    public void removeArticolo(int idLista, int idArticolo) {
        Articolo res = repo.findByIdArticoloAndListaSpesa_IdLista(idArticolo, idLista);
        repo.delete(res);
    }
}
