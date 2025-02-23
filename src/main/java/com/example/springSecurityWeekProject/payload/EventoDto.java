package com.example.springSecurityWeekProject.payload;

import com.example.springSecurityWeekProject.entities.Utente;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EventoDto {
    @NotBlank(message = "questo campo è obbligatorio")
    private String nomeEvento;

    @NotBlank(message = "questo campo è obbligatorio")
    private String descrizioneEvento;

    @NotBlank(message = "questo campo è obbligatorio")
    private LocalDate dataEvento;

    @NotBlank(message = "questo campo è obbligatorio")
    private String luogoEvento;

    @JsonProperty("posti_disponibili")
    @NotBlank(message = "questo campo è obbligatorio")
    @Min(value = 1)
    private int numeroPostiDisponibili;

    @NotBlank(message = "questo campo è obbligatorio")
    private long creatoreEvento_id;
}

// da modificare i not blank message ⚠️⚠️⚠️⚠️⚠️
