package com.example.springSecurityWeekProject.controller;


import com.example.springSecurityWeekProject.payload.UtenteDto;
import com.example.springSecurityWeekProject.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/utente")
public class UtenteController {
    @Autowired
    UtenteService utenteService;


    @GetMapping(value = "/utenti", produces = "application/json")
    public ResponseEntity<Page<UtenteDto>> getAllUtenti(Pageable page) {
        Page<UtenteDto> utenti = utenteService.getAllUtenti(page);
        return new ResponseEntity<>(utenti, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public UtenteDto getUtenteById(@PathVariable long id) {
        return utenteService.trovaUtenteById(id);
    }

    @PostMapping("")
    public ResponseEntity<?> nuovoUtente(@RequestBody @Validated UtenteDto utenteDto, BindingResult validation) {

        if (validation.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder("ERRORE DI VALIDAZIONE \n");

            for (ObjectError errore : validation.getAllErrors()) {
                errorMessage.append(errore.getDefaultMessage()).append("\n");
            }
            return new ResponseEntity<>(errorMessage.toString(), HttpStatus.BAD_REQUEST);
        }
        String nuovoUtente = utenteService.inserisciUtente(utenteDto);
        return new ResponseEntity<>("Utente inserito nel DB con id: " + nuovoUtente, HttpStatus.CREATED);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUtente(@RequestBody @Validated UtenteDto utenteDto, BindingResult validation, @PathVariable long id) {
        if (validation.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder("ERRORE DI VALIDAZIONE \n");

            for (ObjectError errore : validation.getAllErrors()) {
                errorMessage.append(errore.getDefaultMessage()).append("\n");
            }
            return new ResponseEntity<>(errorMessage.toString(), HttpStatus.BAD_REQUEST);
        } else {
            utenteService.aggiornaUtente(utenteDto, id);
            return new ResponseEntity<>("L'utente è stato modificato correttamente", HttpStatus.OK);
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUtente(@PathVariable long id) {
        return new ResponseEntity<>(utenteService.rimuoviUtente(id), HttpStatus.OK);
    }
}