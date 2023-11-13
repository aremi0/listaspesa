package com.listaSpesa.listaspesa.repository;

import com.listaSpesa.listaspesa.entity.ArticoloUtente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticoloAcquistoRepository extends JpaRepository<ArticoloUtente, Integer> {

}
