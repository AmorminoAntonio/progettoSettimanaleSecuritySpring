package com.example.springSecurityWeekProject.services;

import com.example.springSecurityWeekProject.entities.Prenotazione;
import com.example.springSecurityWeekProject.exceptions.NotFoundException;
import com.example.springSecurityWeekProject.payload.PrenotazioneDto;
import com.example.springSecurityWeekProject.repositories.PrenotazioneRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class PrenotazioneService {
    @Autowired
    PrenotazioneRepo prenotazioneRepo;

  /*  public String inserisciPrenotazione(PrenotazioneDto prenotazioneDto) {
        Prenotazione prenotazione = dto_entity(prenotazioneDto);
        prenotazione = prenotazioneRepo.save(prenotazione);
        return "prenotazione creata con successo" + prenotazione;
    }

    public PrenotazioneDto trovaPrenotazioneById(long id) {
        Optional<Prenotazione> prenotazioneTrovata = prenotazioneRepo.findById(id);

        if (prenotazioneTrovata.isPresent()) {
            return entity_dto(prenotazioneTrovata.get());
        } else {
            throw new NotFoundException("Nessuna prenotazione trovata con l'id: " + id);
        }
    }


    public String aggiornaPrenotazione(PrenotazioneDto prenotazioneDto, long id) {
        Optional<Prenotazione> prenotazioneTrovata = prenotazioneRepo.findById(id);

        if (prenotazioneTrovata.isPresent()) {
            Prenotazione prenotazione = prenotazioneTrovata.get();
            prenotazione.setUtentePrenotazione(prenotazioneDto.getUtentePrenotazione());
            prenotazione.setDataPrenotazione(prenotazioneDto.getDataPrenotazione());
            prenotazione.setEventoPrenotato(prenotazioneDto.getEventoPrenotato());
            prenotazioneRepo.save(prenotazione);
            return "Prenotazione dopo modifica: " + prenotazione + "\n" + "Prenotazione modificata correttamente! ";
        } else {
            throw new NotFoundException("Errore nella modifica della prenotazione inserita. Prenotazione non trovata!");
        }
    }


    public String rimuoviPrenotazione(long id) {
        Optional<Prenotazione> prenotazioneTrovata = prenotazioneRepo.findById(id);
        if (prenotazioneTrovata.isPresent()) {
            prenotazioneRepo.delete(prenotazioneTrovata.get());
            return "Prenotazione con id: " + id + " eliminata con successo!";
        } else {
            throw new NotFoundException("Errore nel delete! Nessuna prenotazione trovata con id: " + id);
        }
    }

    public Page<PrenotazioneDto> getAllPrenotazioni(Pageable page) {
        Page<Prenotazione> listaPrenotazioni = prenotazioneRepo.findAll(page);
        List<PrenotazioneDto> listaDto = new ArrayList<>();

        for (Prenotazione prenotazione : listaPrenotazioni.getContent()) {
            PrenotazioneDto dto = entity_dto(prenotazione);
            listaDto.add(dto);
        }
        return new PageImpl<>(listaDto);
    }

    public Prenotazione dto_entity(PrenotazioneDto prenotazioneDto) {
        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setUtentePrenotazione(prenotazioneDto.getUtentePrenotazione());
        prenotazione.setDataPrenotazione(prenotazioneDto.getDataPrenotazione());
        prenotazione.setEventoPrenotato(prenotazioneDto.getEventoPrenotato());
        return prenotazione;
    }

    // travaso ENTITY ---> DTO
    public PrenotazioneDto entity_dto(Prenotazione prenotazione) {
        PrenotazioneDto prenotazioneDto = new PrenotazioneDto();
        prenotazioneDto.setUtentePrenotazione(prenotazione.getUtentePrenotazione());
        prenotazioneDto.setDataPrenotazione(prenotazione.getDataPrenotazione());
        prenotazioneDto.setEventoPrenotato(prenotazione.getEventoPrenotato());
        return prenotazioneDto;
    }*/

}
