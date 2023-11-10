package com.listaSpesa.listaspesa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticoloAcquisto {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "articolo_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Articolo articolo;

    @Column(nullable = false)
    private float quantita;
}
