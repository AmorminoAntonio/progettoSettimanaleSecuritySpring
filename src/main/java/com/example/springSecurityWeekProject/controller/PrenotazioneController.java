package com.example.springSecurityWeekProject.controller;

import com.example.springSecurityWeekProject.payload.PrenotazioneDto;
import com.example.springSecurityWeekProject.services.PrenotazioneService;
import org.apache.coyote.BadRequestException;
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
@RequestMapping("/prenotazione")
public class PrenotazioneController {
    @Autowired
    PrenotazioneService prenotazioneService;

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<Page<PrenotazioneDto>> getAllPrenotazioni(Pageable page) {
        Page<PrenotazioneDto> prenotazioni = prenotazioneService.getAllPrenotazioni(page);
        return new ResponseEntity<>(prenotazioni, HttpStatus.OK);
    }

    @PostMapping("/newReservation")
    public ResponseEntity<?> creaNuovaPrenotazione(@RequestBody @Validated PrenotazioneDto prenotazioneDTO, BindingResult validation) throws BadRequestException {
        if (validation.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder("ERRORE DI VALIDAZIONE \n");

            for (ObjectError errore : validation.getAllErrors()) {
                errorMessage.append(errore.getDefaultMessage()).append("\n");
            }
            return new ResponseEntity<>(errorMessage.toString(), HttpStatus.BAD_REQUEST);
        } else {
            prenotazioneService.inserisciPrenotazione(prenotazioneDTO);
            return new ResponseEntity<>("La prenotazione è stata creata correttamente", HttpStatus.OK);
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePrenotazione(@PathVariable long id) {
        return new ResponseEntity<>(prenotazioneService.rimuoviPrenotazione(id), HttpStatus.OK);
    }
}
