package com.example.springSecurityWeekProject.payload;

import com.example.springSecurityWeekProject.enumerated.Roles;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
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

    @Email(message = "la email inserita non è valida.")
    private String email;

    private String ruolo;
}

// da modificare i not blank message ⚠️⚠️⚠️⚠️⚠️
