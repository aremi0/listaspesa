package com.listaSpesa.listaspesa.repository;

import com.listaSpesa.listaspesa.entity.ArticoloUtente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticoloUtenteRepository extends JpaRepository<ArticoloUtente, Integer> {

}
