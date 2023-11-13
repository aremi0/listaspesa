package com.listaSpesa.listaspesa.entity;

import org.springframework.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Utente {

    @Id
    @SequenceGenerator(name = "utente_seq", sequenceName = "utente_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "utente_seq" )
    private int id;

    @Column(nullable = false)
    private String email;

    private String nome;
}
