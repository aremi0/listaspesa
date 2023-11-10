package com.listaSpesa.listaspesa.repository;

import com.listaSpesa.listaspesa.entity.ListaSpesa;
import com.listaSpesa.listaspesa.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UtenteRepository extends JpaRepository<Utente, Integer> {

}
