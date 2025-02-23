package com.example.springSecurityWeekProject.repositories;

import com.example.springSecurityWeekProject.entities.Utente;
import com.example.springSecurityWeekProject.enumRole.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtenteRepo extends JpaRepository<Utente, Long> {
    Optional<Utente> findByUsername(String username);

    Optional<Utente> findByRuoloUtente(Roles ruoloUtente);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
