package com.example.springSecurityWeekProject.payload;

import com.example.springSecurityWeekProject.entities.Utente;
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

    @NotBlank(message = "questo campo è obbligatorio")
    private int numeroPostiDisponibili;

    @NotBlank(message = "questo campo è obbligatorio")
    private Utente creatoreEvento;

    @NotBlank(message = "questo campo è obbligatorio")
    private Utente utentePerEvento;
}

// da modificare i not blank message ⚠️⚠️⚠️⚠️⚠️
