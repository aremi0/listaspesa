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

    @ManyToOne
    @NonNull
    private ListaSpesa listaSpesa;

    @Override
    public String toString() {
        return "Articolo{" +
                "idArticolo=" + idArticolo +
                ", nomeArticolo='" + nomeArticolo + '\'' +
                ", listaSpesa=" + listaSpesa +
                '}';
    }
}
