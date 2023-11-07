package com.listaSpesa.listaspesa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Articolo {

    @Id
    @GeneratedValue
    private int idArticolo;

    @NonNull
    private String nomeArticolo;
}
