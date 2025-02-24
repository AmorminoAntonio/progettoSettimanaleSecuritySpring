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



}
