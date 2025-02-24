package com.example.springSecurityWeekProject.payload.travasi;

import com.example.springSecurityWeekProject.entities.Evento;
import com.example.springSecurityWeekProject.entities.Utente;
import com.example.springSecurityWeekProject.payload.EventoDto;
import com.example.springSecurityWeekProject.repositories.UtenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TravasiEvento {

    @Autowired
    UtenteRepo utenteRepository;

    public Evento dto_entity(EventoDto eventoDto) {
        Evento evento = new Evento();
        evento.setNomeEvento(eventoDto.getNomeEvento());
        evento.setDataEvento(eventoDto.getDataEvento());
        evento.setDescrizione(eventoDto.getDescrizione());
        evento.setLuogo(eventoDto.getLuogo());
        evento.setCapacita(eventoDto.getCapacita());
        Utente utente = utenteRepository.findById(eventoDto.getOrganizzatore_id()).orElseThrow(() -> new RuntimeException("Utente non trovato"));
        evento.setOrganizzatore(utente);
        return evento;
    }

    // travaso ENTITY ---> DTO
    public EventoDto entity_dto(Evento evento) {
        EventoDto eventoDto = new EventoDto();
        eventoDto.setNomeEvento(evento.getNomeEvento());
        eventoDto.setDataEvento(evento.getDataEvento());
        eventoDto.setDescrizione(evento.getDescrizione());
        eventoDto.setLuogo(evento.getLuogo());
        eventoDto.setCapacita(evento.getCapacita());
        eventoDto.setOrganizzatore_id(evento.getOrganizzatore().getUtente_id());
        return eventoDto;
    }
}
