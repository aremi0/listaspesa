package com.listaSpesa.listaspesa.repository;

import com.listaSpesa.listaspesa.entity.Articolo;
import com.listaSpesa.listaspesa.entity.ListaSpesa;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticoloRepository extends JpaRepository<Articolo, Integer> {

}
