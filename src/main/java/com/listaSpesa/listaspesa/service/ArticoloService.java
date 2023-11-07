package com.listaSpesa.listaspesa.service;

import com.listaSpesa.listaspesa.GenericResponseDTO;
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

    public GenericResponseDTO<Articolo> insertArticoli(List<Articolo> entries) {
        List<Articolo> articoli = new ArrayList<>();

        for (var e : entries) {
            articoli.add(articoloRepository.save(e));
        }

        try {
            return new GenericResponseDTO<>(articoli, false, null);
        } catch (Exception e) {
            return new GenericResponseDTO<>(null, true,
                    "insertArticoli() error: " + e.getMessage());
        }
    }

    public GenericResponseDTO<Articolo> getAllArticoli() {
        try {
            return new GenericResponseDTO<>(articoloRepository.findAll(), false, null);
        } catch (Exception e) {
            return new GenericResponseDTO<>(null, true,
                    "getAllArticoli() error: " + e.getMessage());
        }
    }
}
