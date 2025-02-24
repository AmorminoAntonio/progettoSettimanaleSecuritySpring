package com.example.springSecurityWeekProject.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UtenteDto {
    @NotBlank
    private String nome;
    @NotBlank
    private String cognome;
    @NotBlank
    private String email;
    @NotBlank
    private String username;
    @NotBlank
    @Size(min = 6, max = 18)
    private String password;

    private String ruolo;
}

// da modificare i not blank message ⚠️⚠️⚠️⚠️⚠️
