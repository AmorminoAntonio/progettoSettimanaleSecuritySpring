package com.example.springSecurityWeekProject.repositories;

import com.example.springSecurityWeekProject.entities.Utente;
import com.example.springSecurityWeekProject.enumRole.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtenteRepo extends JpaRepository<Utente, Long> {
    Optional<Utente> findByUsername(String username);

    // x la login
    boolean existsByUsernameAndPassword(String username, String password);

    // per visualizzare alla creazione se l'username è libero (quindi se è presente o no nel db)
    boolean existsByUsername(String username);

    // per visualizzare alla creazione se la mail è già presente o meno sul db
    boolean existsByEmail(String email);
}
