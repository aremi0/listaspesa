package com.listaSpesa.listaspesa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListaSpesa {

    @Id
    @GeneratedValue
    private int id;

    @OneToMany(targetEntity = ArticoloUtente.class)
    @Column(nullable = false)
    private List<ArticoloUtente> articoli;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente proprietario;

    private String nomeListaspesa;
}
