package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Membre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;
    private String abonnement;
    private String status;
    private LocalDateTime dateInscription;

    @OneToMany(mappedBy = "membre")
    private List<Reservation> reservations;

    @ManyToMany
    @JoinTable(
            name = "membre_equipe",
            joinColumns = @JoinColumn(name = "membre_id"),
            inverseJoinColumns = @JoinColumn(name = "equipe_id")
    )
    private List<Equipe> equipes;
}