package com.example.springSecurityWeekProject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "prenotazioni")
@Data
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long prenotazione_id;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utentePrenotazione;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento eventoPrenotato;

    @Column(nullable = false)
    private LocalDate dataPrenotazione;
}
