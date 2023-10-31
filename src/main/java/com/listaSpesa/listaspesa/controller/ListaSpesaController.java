package com.listaSpesa.listaspesa.controller;

import com.listaSpesa.listaspesa.entity.Articolo;
import com.listaSpesa.listaspesa.entity.ListaSpesa;
import com.listaSpesa.listaspesa.service.ArticoloService;
import com.listaSpesa.listaspesa.service.ListaSpesaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.util.List;

@RestController
@RequiredArgsConstructor // Crea un costruttore implicito per tutte le var final dentro la classe
public class ListaSpesaController {

    private final ListaSpesaService listaSpesaService;
    private final ArticoloService articoloService;

    // ResponseEntity è una classe wrapper che contiene, oltre l'oggetto, anche header, error, ecc...
    @GetMapping("/")
    public ResponseEntity<List<ListaSpesa>> getAllListeSpesa() {
        return ResponseEntity.ok(listaSpesaService.getAllListeSpesa());
    }

    @GetMapping("/{idLista}")
    public ResponseEntity<List<Articolo>> getListaById (@PathVariable int idLista) {
        return ResponseEntity.ok(articoloService.findArticoliByListaSpesa(idLista));
    }

    @PostMapping("/")
    public void insertLista(@RequestBody List<Articolo> entities) {
        try{
            listaSpesaService.addListaSpesa(entities);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }

    @PostMapping("/{idLista}")
    public void insertArticoli(@PathVariable int idLista, @RequestBody List<Articolo> entries) {
        listaSpesaService.inserisciArticoliInLista(idLista, entries);
    }

    @PutMapping("/{idLista}/{idArticolo}")
    public void updateArticolo(@PathVariable int idLista, @PathVariable int idArticolo,
                               @RequestBody Articolo entry) {
        articoloService.updateArticolo(idLista, idArticolo, entry);
    }

    @DeleteMapping("/{idLista}/{idArticolo}")
    public void removeArticolo(@PathVariable int idLista, @PathVariable int idArticolo) {
        articoloService.removeArticolo(idLista, idArticolo);
    }
}