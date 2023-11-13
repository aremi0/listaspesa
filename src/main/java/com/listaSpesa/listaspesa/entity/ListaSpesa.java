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
    @SequenceGenerator(name = "listaspesa_seq", sequenceName = "listaspesa_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "listaspesa_seq" )
    private int id;

    private String nomeListaspesa;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente proprietario;

    @OneToMany(targetEntity = ArticoloUtente.class)
    @Column(nullable = false)
    private List<ArticoloUtente> articoli;
}
