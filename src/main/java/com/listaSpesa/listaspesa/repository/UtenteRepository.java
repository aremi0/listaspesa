package com.listaSpesa.listaspesa.repository;

import com.listaSpesa.listaspesa.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Integer> {
    Optional<Utente> findUtenteByEmail(String email);
}
