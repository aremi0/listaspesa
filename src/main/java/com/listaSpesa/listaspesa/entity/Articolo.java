package com.listaSpesa.listaspesa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Articolo {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String nome;
}
