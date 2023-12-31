package com.listaSpesa.listaspesa.repository;

import com.listaSpesa.listaspesa.entity.Articolo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ArticoloRepository extends JpaRepository<Articolo, Integer> {

}
