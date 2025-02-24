package com.example.springSecurityWeekProject.payload;

import com.example.springSecurityWeekProject.entities.Evento;
import com.example.springSecurityWeekProject.entities.Utente;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.time.LocalDate;


@Data
public class PrenotazioneDto {
    @NotBlank(message = "questo campo è obbligatorio")
    private Utente utentePrenotazione;

    @NotBlank(message = "questo campo è obbligatorio")
    private Evento eventoPrenotato;

    @NotBlank(message = "questo campo è obbligatorio")
    private LocalDate dataPrenotazione;
}