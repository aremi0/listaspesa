package com.listaSpesa.listaspesa.controller;

import com.listaSpesa.listaspesa.GenericResponseDTO;
import com.listaSpesa.listaspesa.entity.Utente;
import com.listaSpesa.listaspesa.service.UtenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UtenteController {

    private final UtenteService utenteService;


    @GetMapping("/api/utente")
    public ResponseEntity<GenericResponseDTO<Utente>> getAllUtenti() {
        return ResponseEntity.ok(utenteService.getAllUtenti());
    }

    @PostMapping("/api/utente")
    public ResponseEntity<GenericResponseDTO<Utente>> insertUtenti (@RequestBody List<Utente> entries) {
        return ResponseEntity.ok(utenteService.insertUtenti(entries));
    }

}
