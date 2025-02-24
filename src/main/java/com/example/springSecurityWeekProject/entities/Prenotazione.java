package com.example.springSecurityWeekProject.entities;

import com.example.springSecurityWeekProject.enumerated.StatusType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "utenti")
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_prenotazione;

    @Column(nullable = false)
    private LocalDate dataPrenotazione;

    @Enumerated(EnumType.STRING)
    private StatusType status;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;


}