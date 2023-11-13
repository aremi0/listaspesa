package com.listaSpesa.listaspesa.service;

import com.listaSpesa.listaspesa.entity.ArticoloUtente;
import com.listaSpesa.listaspesa.repository.ArticoloAcquistoRepository;
import com.listaSpesa.listaspesa.utils.GenericResponse;
import com.listaSpesa.listaspesa.dto.ListaSpesaRequest;
import com.listaSpesa.listaspesa.entity.ListaSpesa;
import com.listaSpesa.listaspesa.entity.Utente;
import com.listaSpesa.listaspesa.repository.ListaSpesaRepository;
import com.listaSpesa.listaspesa.repository.UtenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ListaSpesaService {

    private final ListaSpesaRepository listaSpesaRepository;
    private final UtenteRepository utenteRepository;
    private final ArticoloAcquistoRepository articoloAcquistoRepository;

    public GenericResponse<ListaSpesa> insertListaSpesaToUtente(int id, ListaSpesaRequest entry) {
        Optional<Utente> utente = utenteRepository.findById(id);

        if (utente.isEmpty()) {
            throw new IllegalStateException("insertListaSpesa() error: Utente non trovato!");
        }

        List<ArticoloUtente> tmp = articoloAcquistoRepository.saveAll(entry.getArticoli());

        ListaSpesa res = new ListaSpesa();
        res.setNomeListaspesa(entry.getNomeListaspesa());
        res.setProprietario(utente.get());
        res.setArticoli(entry.getArticoli());


        try {
            return new GenericResponse<>(List.of(listaSpesaRepository.save(res)), false, null);
        } catch (Exception e) {
            return new GenericResponse<>(null, true,
                    "insertListaSpesa() error: " + e.getMessage());
        }
    }

    public GenericResponse<ListaSpesa> getListaSpesaOfUtente(int idUtente) {
        Optional<Utente> utente = utenteRepository.findById(idUtente);

        if (utente.isEmpty()) {
            throw new IllegalStateException("insertListaSpesa() error: Utente non trovato!");
        }

        List<ListaSpesa> listaSpesa = new ArrayList<>(listaSpesaRepository.findListaSpesasByProprietario(utente.get()));

        try {
            return new GenericResponse<ListaSpesa>(listaSpesa, false, null);
        } catch (Exception e) {
            return new GenericResponse<>(null, true,
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
