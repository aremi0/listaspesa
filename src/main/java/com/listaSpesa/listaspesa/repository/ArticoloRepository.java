package com.listaSpesa.listaspesa.repository;

import com.listaSpesa.listaspesa.entity.Articolo;
import com.listaSpesa.listaspesa.entity.ListaSpesa;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticoloRepository extends JpaRepository<Articolo, Integer> {
    List<Articolo> findByListaSpesaIdLista(int idL);
    Articolo findByIdArticoloAndListaSpesa_IdLista(int idArticolo, int idLista);
}
