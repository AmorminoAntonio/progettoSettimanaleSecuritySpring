package com.example.springSecurityWeekProject.services;

import com.example.springSecurityWeekProject.entities.Evento;
import com.example.springSecurityWeekProject.entities.Utente;
import com.example.springSecurityWeekProject.exceptions.NotFoundException;
import com.example.springSecurityWeekProject.payload.EventoDto;
import com.example.springSecurityWeekProject.repositories.EventoRepo;
import com.example.springSecurityWeekProject.repositories.UtenteRepo;
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
public class EventoService {
    @Autowired
    EventoRepo eventoRepo;

    @Autowired
    UtenteRepo utenteRepo;

    public String inserisciEvento(EventoDto eventoDto) {
        Evento evento = dto_entity(eventoDto);
        evento = eventoRepo.save(evento);
        return "nuovo evento inserito: " + evento;
    }


    public EventoDto trovaEventoById(long id) {
        Optional<Evento> eventoTrovato = eventoRepo.findById(id);

        if (eventoTrovato.isPresent()) {
            return entity_dto(eventoTrovato.get());
        } else {
            throw new NotFoundException("Nessun evento trovato con l'id: " + id);
        }
    }



    public String rimuoviEvento(long id) {
        Optional<Evento> eventoTrovato = eventoRepo.findById(id);
        if (eventoTrovato.isPresent()) {
            eventoRepo.delete(eventoTrovato.get());
            return "evento con id: " + id + " eliminato con successo!";
        } else {
            throw new NotFoundException("Errore nel delete! Nessun evento trovato con id: " + id);
        }

    }

    public Page<EventoDto> getAllEventi(Pageable page) {
        Page<Evento> listaEventi = eventoRepo.findAll(page);
        List<EventoDto> listaDto = new ArrayList<>();

        for (Evento evento : listaEventi.getContent()) {
            EventoDto dto = entity_dto(evento);
            listaDto.add(dto);
        }
        return new PageImpl<>(listaDto);
    }

    public void addUtente(long eventoId, long utenteId) {
        Optional<Evento> evento = eventoRepo.findById(eventoId);
        Optional<Utente> utente = utenteRepo.findById(utenteId);
        if (evento.isPresent() && utente.isPresent()) {
            Evento eventoDaSalvare = evento.get();
            eventoDaSalvare.setListaUtentiEvento(utente.get());
            eventoRepo.save(eventoDaSalvare);
        } else {
            throw new NotFoundException("Evento o Utente non presenti nel DB !");
        }
    }

    public Evento dto_entity(EventoDto eventoDto) {
        Evento evento = new Evento();
        evento.setNomeEvento(eventoDto.getNomeEvento());
        evento.setDataEvento(eventoDto.getDataEvento());
        evento.setDescrizioneEvento(eventoDto.getDescrizioneEvento());
        evento.setLuogoEvento(eventoDto.getLuogoEvento());
        evento.setNumeroPostiDisponibili(eventoDto.getNumeroPostiDisponibili());
        evento.setCreatoreEvento(eventoDto.getCreatoreEvento());
        return evento;
    }

    // travaso ENTITY ---> DTO
    public EventoDto entity_dto(Evento evento) {
        EventoDto eventoDto = new EventoDto();
        eventoDto.setNomeEvento(evento.getNomeEvento());
        eventoDto.setDataEvento(evento.getDataEvento());
        eventoDto.setDescrizioneEvento(evento.getDescrizioneEvento());
        eventoDto.setLuogoEvento(evento.getLuogoEvento());
        eventoDto.setNumeroPostiDisponibili(evento.getNumeroPostiDisponibili());
        eventoDto.setCreatoreEvento(evento.getCreatoreEvento());
        return eventoDto;
    }
}
