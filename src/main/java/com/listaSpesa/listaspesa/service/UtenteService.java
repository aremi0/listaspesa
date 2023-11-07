package com.listaSpesa.listaspesa.service;

import com.listaSpesa.listaspesa.GenericResponseDTO;
import com.listaSpesa.listaspesa.entity.Utente;
import com.listaSpesa.listaspesa.repository.UtenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UtenteService {

    private final UtenteRepository utenteRepository;

    public GenericResponseDTO<Utente> insertUtenti(List<Utente> entries) {
        List<Utente> utenti = new ArrayList<>();

        for (var e : entries) {
            utenti.add(utenteRepository.save(e));
        }

        try {
            return new GenericResponseDTO<>(utenti, false, null);
        } catch (Exception e) {
            return new GenericResponseDTO<>(null, true,
                    "insertUtenti() error: " + e.getMessage());
        }
    }

    public GenericResponseDTO<Utente> getAllUtenti() {
        try {
            return new GenericResponseDTO<>(utenteRepository.findAll(), false, null);
        } catch (Exception e) {
            return new GenericResponseDTO<>(null, true,
                    "getAllUtenti() error: " + e.getMessage());
        }
    }
}