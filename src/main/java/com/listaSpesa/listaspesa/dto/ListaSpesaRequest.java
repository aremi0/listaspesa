package com.listaSpesa.listaspesa.dto;

import com.listaSpesa.listaspesa.entity.ArticoloUtente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ListaSpesaRequest {
    private String nomeListaspesa;
    private List<ArticoloUtente> articoli;
}
