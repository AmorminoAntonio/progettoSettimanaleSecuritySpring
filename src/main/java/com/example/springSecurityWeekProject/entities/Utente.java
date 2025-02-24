package com.example.springSecurityWeekProject.entities;

import com.example.springSecurityWeekProject.enumerated.Roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "utenti")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long utente_id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cognome;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Roles ruolo;

    @OneToMany(mappedBy = "evento_id")
    private List<Evento> eventoList;

    @OneToMany(mappedBy = "prenotazione_id")
    private List<Prenotazione> prenotazioneList;
}
