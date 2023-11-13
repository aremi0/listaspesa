package com.listaSpesa.listaspesa.repository;

import com.listaSpesa.listaspesa.entity.ListaSpesa;
import com.listaSpesa.listaspesa.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListaSpesaRepository extends JpaRepository<ListaSpesa, Integer> {

    List<ListaSpesa> findListaSpesasByProprietario(Utente p);

}
