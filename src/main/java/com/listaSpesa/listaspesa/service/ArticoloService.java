package com.listaSpesa.listaspesa.service;

import com.listaSpesa.listaspesa.utils.GenericResponse;
import com.listaSpesa.listaspesa.entity.Articolo;
import com.listaSpesa.listaspesa.repository.ArticoloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticoloService {

    private final ArticoloRepository articoloRepository;

    public GenericResponse<Articolo> insertArticoli(List<Articolo> entries) {

        List<Articolo> articoli = articoloRepository.saveAll(entries);

        try {
            return new GenericResponse<>(articoli, false, null);
        } catch (Exception e) {
            return new GenericResponse<>(null, true,
                    "insertArticoli() error: " + e.getMessage());
        }
    }

    public GenericResponse<Articolo> getAllArticoli() {
        try {
            return new GenericResponse<>(articoloRepository.findAll(), false, null);
        } catch (Exception e) {
            return new GenericResponse<>(null, true,
                    "getAllArticoli() error: " + e.getMessage());
        }
    }
}
