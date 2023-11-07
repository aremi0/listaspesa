package com.listaSpesa.listaspesa.service;

import com.listaSpesa.listaspesa.GenericResponseDTO;
import com.listaSpesa.listaspesa.entity.ListaSpesa;
import com.listaSpesa.listaspesa.entity.Utente;
import com.listaSpesa.listaspesa.repository.ArticoloRepository;
import com.listaSpesa.listaspesa.repository.ListaSpesaRepository;
import com.listaSpesa.listaspesa.repository.UtenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ListaSpesaService {

    private final ListaSpesaRepository listaSpesaRepository;
    private final UtenteRepository utenteRepository;
    private final ArticoloRepository articoloRepository;

    public GenericResponseDTO<ListaSpesa> insertListaSpesaForUtente(int idUtente, Map<String, Integer> listaspesa) {
        Optional<Utente> utente = utenteRepository.findById(idUtente);

        if (utente.isEmpty()) {
            return new GenericResponseDTO<>(null, true,
                    "insertListaSpesa() error: Utente non trovato!");
        }

        List<ListaSpesa> listaSpesa = new ArrayList<>();
        ListaSpesa ls = new ListaSpesa();
        ls.setProprietario(utente.get());

        for (var entry : listaspesa.entrySet()) {
            ls.setNomeArticolo(entry.getKey());
            ls.setQuantita(entry.getValue());
            listaSpesa.add(listaSpesaRepository.save(ls));
        }

        try {
            return new GenericResponseDTO<>(listaSpesa, false, null);
        } catch (Exception e) {
            return new GenericResponseDTO<>(null, true,
                    "insertListaSpesa() error: " + e.getMessage());
        }
    }

    public GenericResponseDTO<ListaSpesa> getListaSpesaOfUtente(int idUtente) {
        Optional<Utente> utente = utenteRepository.findById(idUtente);

        if (utente.isEmpty()) {
            return new GenericResponseDTO<>(null, true,
                    "insertListaSpesa() error: Utente non trovato!");
        }

        List<ListaSpesa> listaSpesa = new ArrayList<>(listaSpesaRepository.findListaSpesaByProprietario(utente.get()));

        try {
            return new GenericResponseDTO<>(listaSpesa, false, null);
        } catch (Exception e) {
            return new GenericResponseDTO<>(null, true,
                    "insertListaSpesa() error: " + e.getMessage());
        }
    }

//    public GenericResponseDTO<ListaSpesa> getAllListeSpesa() {
//        try {
//            genericResponseDTO = new GenericResponseDTO<>(listaSpesaRepo.findAll(),
//                    false, null);
//        } catch (Exception e) {
//            genericResponseDTO = new GenericResponseDTO<>(null,
//                    true, "getAllListeSpesa() error: " + e.getMessage());
//        }
//
//        return genericResponseDTO;
//    }
//
//    public GenericResponseDTO<ListaSpesa> addListaSpesa(List<Articolo> entities) {
//
//        List<ListaSpesa> ret = new ArrayList<>();
//        ListaSpesa res = new ListaSpesa();
//
//        for (var e : entities) {
//            res.setArticoli(e);
//            ret.add(listaSpesaRepo.save(res));
//        }
//
//        try {
//            genericResponseDTO = new GenericResponseDTO<>(ret,
//                    false, null);
//        } catch (Exception e) {
//            genericResponseDTO = new GenericResponseDTO<>(null,
//                    true, "addListaSpesa() error: " + e.getMessage());
//        }
//
//        return genericResponseDTO;
//    }
//
//    public GenericResponseDTO<ListaSpesa> inserisciArticoliInLista(int idLista, List<Articolo> entries) {
//
//        ListaSpesa res
//
//        for (var articolo : entries) {
//
//        }
//
//        try {
//            genericResponseDTO = new GenericResponseDTO<>(List.of(listaSpesaRepo.save(res)),
//                    false, null);
//        } catch (Exception e) {
//            genericResponseDTO = new GenericResponseDTO<>(null,
//                    true, "addListaSpesa() error: " + e.getMessage());
//        }
//
//        return genericResponseDTO;
//    }
}
