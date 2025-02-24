package com.example.springSecurityWeekProject.payload.travasi;

import com.example.springSecurityWeekProject.entities.Role;
import com.example.springSecurityWeekProject.entities.Utente;
import com.example.springSecurityWeekProject.enumRole.Roles;
import com.example.springSecurityWeekProject.payload.UtenteDto;
import com.example.springSecurityWeekProject.repositories.RuoloRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TravasiUtente {

    @Autowired
    RuoloRepo ruoloRepo;

    public Utente dto_entity(UtenteDto utenteDto) {
        Utente user = new Utente();
        user.setNome(utenteDto.getNome());
        user.setCognome(utenteDto.getCognome());
        user.setUsername(utenteDto.getUsername());
        user.setPassword(utenteDto.getPassword());
        user.setEmail(utenteDto.getEmail());
        Role ruolo = ruoloRepo.findByName(Roles.valueOf(String.valueOf(user.getRuolo()))).orElseThrow(() -> new RuntimeException("Ruolo non trovato"));
        user.setRuolo(ruolo);
        return user;
    }

    // travaso ENTITY ---> DTO
    public UtenteDto entity_dto(Utente utente) {
        UtenteDto userDto = new UtenteDto();
        userDto.setNome(utente.getNome());
        userDto.setCognome(utente.getCognome());
        userDto.setUsername(utente.getUsername());
        userDto.setPassword(utente.getPassword());
        userDto.setEmail(utente.getEmail());
        userDto.setRuolo(utente.getRuolo().toString());
        return userDto;
    }
}
