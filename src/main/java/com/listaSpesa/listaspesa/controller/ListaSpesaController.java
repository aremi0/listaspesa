package com.listaSpesa.listaspesa.controller;

import com.listaSpesa.listaspesa.utils.GenericResponse;
import com.listaSpesa.listaspesa.dto.ListaSpesaRequest;
import com.listaSpesa.listaspesa.entity.ListaSpesa;
import com.listaSpesa.listaspesa.service.ListaSpesaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor // Crea un costruttore implicito per tutte le var final dentro la classe
@RequestMapping("/api/utente/{id_utente}")
public class ListaSpesaController {

    private final ListaSpesaService listaSpesaService;


    @GetMapping("/listaspesa")
    public ResponseEntity<GenericResponse<ListaSpesa>> getListaSpesaOfUtente(@PathVariable int id_utente) {
        return ResponseEntity.ok(listaSpesaService.getListaSpesaOfUtente(id_utente));
    }

    @PostMapping("/listaspesa")
    public ResponseEntity<GenericResponse<ListaSpesa>> insertListaSpesaToUtente(
            @PathVariable int id_utente, @RequestBody ListaSpesaRequest entry) {
        return ResponseEntity.ok(listaSpesaService.insertListaSpesaToUtente(id_utente, entry));
    }










    // ResponseEntity è una classe wrapper che contiene, oltre l'oggetto, anche header, error, ecc...
//    @GetMapping("/")
//    public ResponseEntity<GenericResponseDTO<ListaSpesa>> getAllListeSpesa() {
//        return ResponseEntity.ok(listaSpesaService.getAllListeSpesa());
//    }
//
//    @PostMapping("/")
//    public ResponseEntity<GenericResponseDTO<ListaSpesa>> insertLista(@RequestBody List<Articolo> entities) {
//        return ResponseEntity.ok(listaSpesaService.addListaSpesa(entities));
//    }
//
//    @PostMapping("/{idLista}")
//    public void insertArticoli(@PathVariable int idLista, @RequestBody List<Articolo> entries) {
//        listaSpesaService.inserisciArticoliInLista(idLista, entries);
//    }
}