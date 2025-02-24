package com.example.springSecurityWeekProject.repositories;

import com.example.springSecurityWeekProject.entities.Evento;
import com.example.springSecurityWeekProject.entities.Prenotazione;
import com.example.springSecurityWeekProject.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface PrenotazioneRepo extends JpaRepository<Prenotazione, Long> {
    Optional<Prenotazione> findByUtente(Utente utente);

    Optional<Prenotazione> findByDataPrenotazione(LocalDate dataPrenotazione);
}
