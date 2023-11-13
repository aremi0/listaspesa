package com.listaSpesa.listaspesa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Articolo {

    @Id
    @SequenceGenerator(name = "articolo_seq", sequenceName = "articolo_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "articolo_seq" )
    private int id;

    @Column(nullable = false)
    private String nome;
}
