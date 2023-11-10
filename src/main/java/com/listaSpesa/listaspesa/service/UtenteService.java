package com.listaSpesa.listaspesa.service;

import com.listaSpesa.listaspesa.entity.ListaSpesa;
import com.listaSpesa.listaspesa.utils.GenericResponse;
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

    public GenericResponse<Utente> insertUtenti(List<Utente> entries) {
        List<Utente> utenti = new ArrayList<>();

        for (var e : entries) {
            utenti.add(utenteRepository.save(e));
        }

        try {
            return new GenericResponse<>(utenti, false, null);
        } catch (Exception e) {
            return new GenericResponse<>(null, true,
                    "insertUtenti() error: " + e.getMessage());
        }
    }

    public GenericResponse<Utente> getAllUtenti() {
        try {
            return new GenericResponse<>(utenteRepository.findAll(), false, null);
        } catch (Exception e) {
            return new GenericResponse<>(null, true,
                    "getAllUtenti() error: " + e.getMessage());
        }
    }
}
