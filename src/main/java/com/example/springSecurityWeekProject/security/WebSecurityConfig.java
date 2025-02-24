package com.example.springSecurityWeekProject.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity(debug = true)
public class WebSecurityConfig {


    // Gestore csrf
    // Andiamo a impostare il nostro gestore delle autorizzazioni KO
    // Gestione della sessione
    // Gestione autorizzazioni sulle richieste (a livello controller / a livello di singoli servizi controller)
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers("/utente/register", "/utente/login").permitAll()
                                .requestMatchers("/api/products/**").permitAll()
                                .anyRequest().authenticated()).sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
                        return http.build();
    }

    /*


    // Spring crea in automatico un oggetto Password Encoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // FORNISCE L'AUTENTICAZIONE ATTRAVERSO I DETTAGLI USERNAME E PASSWORD
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        // Gestione di come deve essere creato e inizializzato l'oggetto DaoAuthenticationProvider
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();

        // L'oggetto importa tutti i dettagli utente
        auth.setUserDetailsService(detailsImpl);

        // DaoAuthenticationProvider fornisce un metodo per accettare la password criptata.
        auth.setPasswordEncoder(passwordEncoder());

        return auth;
    }*/

}
