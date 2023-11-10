package com.listaSpesa.listaspesa.entity;

import com.listaSpesa.listaspesa.dto.ListaSpesaRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;


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

    @OneToMany(targetEntity = ArticoloAcquisto.class)
    @Column(nullable = false)
    private List<ArticoloAcquisto> articoli;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente proprietario;

    private String nomeListaspesa;
}
