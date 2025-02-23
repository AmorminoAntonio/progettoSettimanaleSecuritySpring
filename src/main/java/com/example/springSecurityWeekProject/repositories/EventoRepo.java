package com.example.springSecurityWeekProject.repositories;

import com.example.springSecurityWeekProject.entities.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;


@Repository
public interface EventoRepo extends JpaRepository<Evento, Long> {
    Optional<Evento> findByLuogoEvento(String luogoEvento);

    Optional<Evento> findByDataEvento(LocalDate dataEvento);
}
