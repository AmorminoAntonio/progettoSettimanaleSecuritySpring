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

}
