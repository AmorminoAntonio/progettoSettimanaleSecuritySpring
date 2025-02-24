package com.example.springSecurityWeekProject.controllers;

import com.example.springSecurityWeekProject.payload.EventoDto;
import com.example.springSecurityWeekProject.services.EventoService;
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
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    EventoService eventoService;

    @GetMapping(value = "/eventi", produces = "application/json")
    public ResponseEntity<Page<EventoDto>> getAllEventi(Pageable page) {
        Page<EventoDto> evento = eventoService.getAllEventi(page);
        return new ResponseEntity<>(evento, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public EventoDto getEventoById(@PathVariable long id) {
        return eventoService.trovaEventoById(id);
    }

    @PutMapping("/modifica/{id}")
    public ResponseEntity<?> updateEvento(@RequestBody @Validated EventoDto eventoDto, BindingResult validation, @PathVariable long id) {
        if (validation.hasErrors()) {
            StringBuilder messaggioErrori = new StringBuilder("ERRORE DI VALIDAZIONE \n");

            for (ObjectError errore : validation.getAllErrors()) {
                messaggioErrori.append(errore.getDefaultMessage()).append("\n");
            }
            return new ResponseEntity<>(messaggioErrori.toString(), HttpStatus.BAD_REQUEST);
        } else {
            eventoService.aggiornaEvento(eventoDto, id);
            return new ResponseEntity<>("L'evento è stato modificato correttamente", HttpStatus.OK);
        }
    }

    @PutMapping("assegnaDipendente/{viaggioId}/{dipendenteId}")
    public ResponseEntity<?> aggiungiUtenteAllEvento(@PathVariable long viaggioId, @PathVariable long dipendenteId) {
        eventoService.addUtente(viaggioId, dipendenteId);
        return new ResponseEntity<>("Dipendente (id:" + dipendenteId + ") aggiunto a viaggio (" + viaggioId + ")", HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEvento(@PathVariable long id) {
        return new ResponseEntity<>(eventoService.rimuoviEvento(id), HttpStatus.OK);
    }
}


