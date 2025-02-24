package com.example.springSecurityWeekProject.entities;

import com.example.springSecurityWeekProject.enumRole.Roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role ruolo;

    @OneToMany(mappedBy = "id_evento")
    private List<Evento> eventoList;

    @OneToMany(mappedBy = "id_prenotazione")
    private List<Prenotazione> prenotazioneList;
}
