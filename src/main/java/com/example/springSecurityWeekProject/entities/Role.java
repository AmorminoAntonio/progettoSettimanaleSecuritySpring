package com.example.springSecurityWeekProject.entities;

import com.example.springSecurityWeekProject.enumRole.Roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ruoli")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long role_id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, unique = true)
    private Roles name; // ENUM

    @OneToMany(mappedBy = "ruolo", fetch = FetchType.LAZY)
    private Set<Utente> utenti = new HashSet<>();

    @Override
    public String toString() {
        return "Role{id=" + role_id + ", name=" + name + "}";
    }

    @Override
    public int hashCode() {
        return role_id != null ? role_id.hashCode() : 0;
    }
}
