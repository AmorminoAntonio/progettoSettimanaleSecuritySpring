package com.example.springSecurityWeekProject.payload;

import com.example.springSecurityWeekProject.entities.Utente;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EventoDto {

    @NotBlank
    private String nomeEvento;
    @NotBlank
    private String descrizione;
    @NotBlank
    private LocalDate dataEvento;
    @NotBlank
    private String luogo;
    @NotBlank
    private String città;
    @NotBlank
    private int capacita;
    @NotBlank
    private long organizzatore_id;
}

// da modificare i not blank message ⚠️⚠️⚠️⚠️⚠️
