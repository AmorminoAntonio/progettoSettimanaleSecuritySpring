package com.example.springSecurityWeekProject.security.services;


import com.example.springSecurityWeekProject.entities.Utente;
import com.example.springSecurityWeekProject.enumerated.Roles;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
public class UtenteDetailsImpl implements UserDetails {

    // stiamo personalizzando i dettagli da inserire nel token JWT

    private Long id;
    private String username;
    private String email;

    @JsonIgnore
    private String password;
    private Roles ruolo;


    public static UtenteDetailsImpl costruisciDettagli(Utente user) {
        return new UtenteDetailsImpl(user.getUtente_id(), user.getUsername(), user.getEmail(), user.getPassword(), user.getRuolo());
    }


    // da modificare tramite visione della repo di EDO
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(ruolo.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
