package com.example.springSecurityWeekProject.controller;


import com.example.springSecurityWeekProject.entities.Utente;
import com.example.springSecurityWeekProject.payload.UtenteDto;
import com.example.springSecurityWeekProject.payload.travasi.TravasiUtente;
import com.example.springSecurityWeekProject.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/utente")
public class UtenteController {
    @Autowired
    UtenteService utenteService;
    @Autowired
    TravasiUtente mapper;


    @PostMapping("/register")
    public UtenteDto registerUser(@RequestBody @Validated UtenteDto utenteDTO) {
        Utente utente = utenteService.createNewUtente(utenteDTO);
        return mapper.entity_dto(utente);
    }
}