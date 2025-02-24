package com.example.springSecurityWeekProject.controller;


import com.example.springSecurityWeekProject.entities.Utente;
import com.example.springSecurityWeekProject.exceptions.EmailDuplicated;
import com.example.springSecurityWeekProject.exceptions.UsernameDuplicated;
import com.example.springSecurityWeekProject.payload.UtenteDto;
import com.example.springSecurityWeekProject.payload.request.RegistrazioneRequest;
import com.example.springSecurityWeekProject.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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


    @PostMapping("/new")
    public ResponseEntity<String> inserisciUtente(@Validated @RequestBody RegistrazioneRequest nuovoUtente, BindingResult validazione) {

        try {

            if (validazione.hasErrors()) {
                StringBuilder errori = new StringBuilder("Problemi nella validazione dati :\n");

                for (ObjectError errore : validazione.getAllErrors()) {
                    errori.append(errore.getDefaultMessage()).append("\n");
                }

                return new ResponseEntity<>(errori.toString(), HttpStatus.BAD_REQUEST);

            }

            String messaggio = utenteService.inserisciUtente(nuovoUtente);
            return new ResponseEntity<>(messaggio, HttpStatus.OK);
        } catch (UsernameDuplicated e) {
            return new ResponseEntity<>("Username già utilizzato", HttpStatus.BAD_REQUEST);
        } catch (EmailDuplicated e) {
            return new ResponseEntity<>("Email non disponibile", HttpStatus.BAD_REQUEST);
        }
    }
}