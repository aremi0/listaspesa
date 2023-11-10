package com.listaSpesa.listaspesa.controller;

import com.listaSpesa.listaspesa.utils.GenericResponse;
import com.listaSpesa.listaspesa.entity.Utente;
import com.listaSpesa.listaspesa.service.UtenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/utente")
public class UtenteController {

    private final UtenteService utenteService;


    @GetMapping
    public ResponseEntity<GenericResponse<Utente>> getAll() {
        return ResponseEntity.ok(utenteService.getAllUtenti());
    }

    @PostMapping
    public ResponseEntity<GenericResponse<Utente>> insertUtenti (@RequestBody List<Utente> entries) {
        return ResponseEntity.ok(utenteService.insertUtenti(entries));
    }

}
