package com.listaSpesa.listaspesa.service;

import com.listaSpesa.listaspesa.entity.ListaSpesa;
import com.listaSpesa.listaspesa.utils.GenericResponse;
import com.listaSpesa.listaspesa.entity.Utente;
import com.listaSpesa.listaspesa.repository.UtenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UtenteService {

    private final UtenteRepository utenteRepository;

    public GenericResponse<Utente> insertUtenti(List<Utente> entries) {
        Optional<Utente> utente;

        for (var e : entries) {
            utente = utenteRepository.findUtenteByEmail(e.getEmail());

            if(utente.isPresent())
                throw new InvalidParameterException("insertUtenti() error: " +
                        utente.get().getEmail() + " già utilizzata!");
        }

        try {
            List<Utente> utenti = utenteRepository.saveAll(entries);
            return new GenericResponse<>(utenti, false, null);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("insertUtenti() error: Alcuni utenti presentano parametri illegali!");
        }
    }

    public GenericResponse<Utente> getAllUtenti() {
        return new GenericResponse<>(utenteRepository.findAll(), false, null);
    }
}
