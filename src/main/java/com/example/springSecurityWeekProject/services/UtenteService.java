package com.example.springSecurityWeekProject.services;

import com.example.springSecurityWeekProject.entities.Utente;
import com.example.springSecurityWeekProject.exceptions.EmailDuplicated;
import com.example.springSecurityWeekProject.exceptions.NotFoundException;
import com.example.springSecurityWeekProject.exceptions.UsernameDuplicated;
import com.example.springSecurityWeekProject.payload.UtenteDto;
import com.example.springSecurityWeekProject.repositories.RuoloRepo;
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
public class UtenteService {
    @Autowired
    UtenteRepo utenteRepo;

    @Autowired
    RuoloRepo ruoloRepo;

    /*public String inserisciUtente(UtenteDto utenteDto) {
        Utente user = dto_entity(utenteDto);
        user = utenteRepo.save(user);
        return "nuovo utente inserito: " + user;
    }

    // controllo duplicato Username e Password
    public void controlloDuplicati(String username, String email) throws UsernameDuplicated, EmailDuplicated {

        if (utenteRepo.existsByUsername(username)) {
            throw new UsernameDuplicated("Username gia esistente nel sistema");
        }

        if (utenteRepo.existsByEmail(email)) {
            throw new EmailDuplicated("Email gia presente nel sistema");
        }

    }


    public UtenteDto trovaUtenteById(long id) {
        Optional<Utente> utenteTrovato = utenteRepo.findById(id);

        if (utenteTrovato.isPresent()) {
            return entity_dto(utenteTrovato.get());
        } else {
            throw new NotFoundException("Nessun utente trovato con l'id: " + id);
        }
    }

    public void aggiornaUtente(UtenteDto utenteDto, long id) {
        Optional<Utente> utenteTrovato = utenteRepo.findById(id);

        if (utenteTrovato.isPresent()) {
            Utente utente = utenteTrovato.get();
            utente.setUsername(utenteDto.getUsername());
            utente.setNome(utenteDto.getNome());
            utente.setCognome(utenteDto.getCognome());
            utenteRepo.save(utente);
        } else {
            throw new NotFoundException("Errore nella modifica dell'utente inserito. Utente non trovato!");
        }
    }


    public String aggiornaUsernameUtente(String username, long id) {
        Optional<Utente> utenteTrovato = utenteRepo.findById(id);
        // l'oggetto è agganciato al DB
        Utente user = utenteTrovato.orElseThrow();
        // Hibernate effettua un update sulla tabella utente
        user.setUsername(username);
        return "username aggiornato correttamente --> " + username;
    }


    public String rimuoviUtente(long id) {
        Optional<Utente> dipendenteTrovato = utenteRepo.findById(id);
        if (dipendenteTrovato.isPresent()) {
            utenteRepo.delete(dipendenteTrovato.get());
            return "utente con id: " + id + " eliminato con successo!";
        } else {
            throw new NotFoundException("Errore nel delete! Nessun utente trovato con id: " + id);
        }

    }

    public Page<UtenteDto> getAllUtenti(Pageable page) {
        Page<Utente> listaUtenti = utenteRepo.findAll(page);
        List<UtenteDto> listaDto = new ArrayList<>();

        for (Utente utente : listaUtenti.getContent()) {
            UtenteDto dto = entity_dto(utente);
            listaDto.add(dto);
        }
        return new PageImpl<>(listaDto);
    }*/



}
