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
public class Market {

    @Id
    @SequenceGenerator(name = "market_seq", sequenceName = "market_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "market_seq" )
    private int id;

    private String nome;

    @OneToMany(targetEntity = ArticoloMarket.class)
    @Column(nullable = true)
    private List<ArticoloMarket> inventario;
}
