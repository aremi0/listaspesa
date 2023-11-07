package com.listaSpesa.listaspesa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListaSpesa {
    @Id
    @GeneratedValue
    private int idLista;

    @NonNull
    private String nomeArticolo;

    @NonNull
    private int quantita;

    @ManyToOne
    @NonNull
    private Utente proprietario;
}
