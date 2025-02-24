package com.example.springSecurityWeekProject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "eventi")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_evento;

    @Column(nullable = false)
    private String nomeEvento;

    @Column(nullable = true)
    private String descrizione;

    @Column(nullable = false)
    private LocalDate dataEvento;

    @Column(nullable = false)
    private String luogo;

    @Column(nullable = false)
    private String città;

    @Column(nullable = false)
    private int capacita;

    @ManyToOne
    @JoinColumn(name = "organizzatore_id")
    private Utente organizzatore;
}
