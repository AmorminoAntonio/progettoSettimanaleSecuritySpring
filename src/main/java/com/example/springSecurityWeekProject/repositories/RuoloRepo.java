package com.example.springSecurityWeekProject.repositories;

import com.example.springSecurityWeekProject.entities.Role;
import com.example.springSecurityWeekProject.enumRole.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RuoloRepo extends JpaRepository<Role, Long> {
    Optional<Role> findByName(Roles name);
}
