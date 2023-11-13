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
    private int id;

    private String nome;

    @OneToMany(targetEntity = ArticoloMarket.class)
    @Column(nullable = false)
    private List<ArticoloMarket> inventario;
}
