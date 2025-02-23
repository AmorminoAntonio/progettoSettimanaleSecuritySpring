package com.example.springSecurityWeekProject.entities;

import com.example.springSecurityWeekProject.enumRole.Roles;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Ruolo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ruolo_id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Roles tipoRuolo;

}
