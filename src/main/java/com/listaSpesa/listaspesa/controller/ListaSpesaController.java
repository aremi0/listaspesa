package com.listaSpesa.listaspesa.controller;

import com.listaSpesa.listaspesa.GenericResponseDTO;
import com.listaSpesa.listaspesa.entity.Articolo;
import com.listaSpesa.listaspesa.entity.ListaSpesa;
import com.listaSpesa.listaspesa.service.ListaSpesaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor // Crea un costruttore implicito per tutte le var final dentro la classe
public class ListaSpesaController {

    private final ListaSpesaService listaSpesaService;


    @GetMapping("/api/utente/{id_utente}/listaspesa")
    public ResponseEntity<GenericResponseDTO<ListaSpesa>> getListaSpesaOfUtente(@PathVariable int id_utente) {
        return ResponseEntity.ok(listaSpesaService.getListaSpesaOfUtente(id_utente));
    }

    @PostMapping("/api/utente/{id_utente}/listaspesa")
    public ResponseEntity<GenericResponseDTO<ListaSpesa>> insertListaSpesaForUtente(
            @PathVariable int id_utente, @RequestBody Map<String, Integer> listaspesa) {
        return ResponseEntity.ok(listaSpesaService.insertListaSpesaForUtente(id_utente, listaspesa));
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