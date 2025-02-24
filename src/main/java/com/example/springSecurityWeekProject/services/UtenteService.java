package com.example.springSecurityWeekProject.services;

import com.example.springSecurityWeekProject.entities.Utente;
import com.example.springSecurityWeekProject.exceptions.EmailDuplicated;
import com.example.springSecurityWeekProject.exceptions.NotFoundException;
import com.example.springSecurityWeekProject.exceptions.UsernameDuplicated;
import com.example.springSecurityWeekProject.payload.UtenteDto;
import com.example.springSecurityWeekProject.payload.travasi.TravasiUtente;
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
    UtenteRepo utenteRepository;
    @Autowired
    TravasiUtente mapper;


    public Utente createNewUtente(UtenteDto utenteDTO) {
        Utente utente = mapper.dto_entity(utenteDTO);
        return utenteRepository.save(utente);

    }


}
