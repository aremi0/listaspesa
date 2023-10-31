package com.listaSpesa.listaspesa.repository;

import com.listaSpesa.listaspesa.entity.ListaSpesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaSpesaRepository extends JpaRepository<ListaSpesa, Integer> {
    ListaSpesa findListaSpesaByIdLista(int idLista);
}
