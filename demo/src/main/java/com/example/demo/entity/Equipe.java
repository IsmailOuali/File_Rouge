package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String niveau;

    @ManyToMany(mappedBy = "equipes")
    private List<Membre> membres;

    @OneToMany(mappedBy = "equipe")
    private List<Match> matches;
}
