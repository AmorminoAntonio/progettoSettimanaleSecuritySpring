package com.example.springSecurityWeekProject.payload;

import com.example.springSecurityWeekProject.entities.Ruolo;
import com.example.springSecurityWeekProject.enumRole.Roles;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UtenteDto {
    @NotBlank(message = "questo campo è obbligatorio")
    private String nome;

    @NotBlank(message = "questo campo è obbligatorio")
    private String cognome;

    @NotBlank(message = "questo campo è obbligatorio")
    private String username;

    @NotBlank(message = "questo campo è obbligatorio")
    private String password;

    @NotBlank(message = "questo campo è obbligatorio")
    private String email;

    private Ruolo ruolo;
}

// da modificare i not blank message ⚠️⚠️⚠️⚠️⚠️
