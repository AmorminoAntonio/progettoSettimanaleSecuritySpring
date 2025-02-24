package com.example.springSecurityWeekProject.security.jwt;


import com.example.springSecurityWeekProject.security.services.UtenteDetailsImplService;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


public class FilterAuthToken extends OncePerRequestFilter {

    @Autowired
    JwtUtils utils;

    @Autowired
    UtenteDetailsImplService userDetailsService;

    private String analizzaJwt(HttpServletRequest request) {
        String headAutenticazione = request.getHeader("Authorization");

        // 1. Controllo sulla presenza di testo nel valore di Authorization
        // 2  Controlla se il valore recuperato inizia con "Bearer "
        // Bearer f7365dj38jkso34936djh73hd73
        if (StringUtils.hasText(headAutenticazione) && (headAutenticazione.startsWith("Bearer "))) {
            // RECUPERO LA SOTTOSTRINGA ESCLUDENDO LA PRIMA SEQUENZA STANDARD
            return headAutenticazione.substring(7);
        }
        return null;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String jwt = analizzaJwt(request);

            // se la richiesta presenta un JWT, la convalidiamo
            if (jwt != null && utils.validazioneJwtToken(jwt)) {

                // recupero l'username dal token jwt
                String username = utils.recuperoUsernameDaToken(jwt);

                // recuperiamo UserDetails da Username -> creare un oggetto Authentication
                UserDetails dettagliUtente = userDetailsService.loadUserByUsername(username);

                // creazione di un oggetto UsernamePasswordAuthenticationToken
                UsernamePasswordAuthenticationToken autenticazione =
                        new UsernamePasswordAuthenticationToken(
                                dettagliUtente,
                                null,
                                dettagliUtente.getAuthorities());

                // settiamo nei dettagli dell'oggetto UsernamePasswordAuthenticationToken
                autenticazione.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                //impostare lo UserDetails corrente nel contesto (ambiente) di Security
                SecurityContextHolder.getContext().setAuthentication(autenticazione);
            }
            // otteniamo JWT dai cookie http

        } catch (Exception e) {
            System.out.println("errore durante l'autenticazione dell'utente: {}" + e.getMessage());
        }

        filterChain.doFilter(request, response);  // continua con la catena di filtri.

    }
}
