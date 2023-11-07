package com.listaSpesa.listaspesa.controller;

import com.listaSpesa.listaspesa.GenericResponseDTO;
import com.listaSpesa.listaspesa.entity.Articolo;
import com.listaSpesa.listaspesa.service.ArticoloService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ArticoloController {

    private final ArticoloService articoloService;

    @GetMapping("/api/articoli")
    public ResponseEntity<GenericResponseDTO<Articolo>> getAllArticoli() {
        return ResponseEntity.ok(articoloService.getAllArticoli());
    }

    @PostMapping("/api/articoli")
    public ResponseEntity<GenericResponseDTO<Articolo>> insertArticoli(@RequestBody List<Articolo> entries) {
        return ResponseEntity.ok(articoloService.insertArticoli(entries));
    }






//    @GetMapping("/{idLista}")
//    public ResponseEntity<List<Articolo>> getListaById (@PathVariable int idLista) {
//        return ResponseEntity.ok(articoloService.findArticoliByListaSpesa(idLista));
//    }
//
//    @PutMapping("/{idLista}/{idArticolo}")
//    public void updateArticolo(@PathVariable int idLista, @PathVariable int idArticolo,
//                               @RequestBody Articolo entry) {
//        articoloService.updateArticolo(idLista, idArticolo, entry);
//    }
//
//    @DeleteMapping("/{idLista}/{idArticolo}")
//    public void removeArticolo(@PathVariable int idLista, @PathVariable int idArticolo) {
//        articoloService.removeArticolo(idLista, idArticolo);
//    }
}
