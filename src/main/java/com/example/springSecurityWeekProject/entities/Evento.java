package com.example.springSecurityWeekProject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "eventi")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long evento_id;

    @Column(nullable = false)
    private String nomeEvento;

    @Column
    private String descrizioneEvento;

    @Column(nullable = false)
    private LocalDate dataEvento;

    @Column(nullable = false)
    private String luogoEvento;

    @Column(nullable = false)
    private int numeroPostiDisponibili;

    @ManyToOne
    @JoinColumn
    private Utente utentePerEvento;

    @ManyToOne
    @JoinColumn(name = "creatore_evento_id")
    private Utente creatoreEvento;
}