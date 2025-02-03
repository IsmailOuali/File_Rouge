package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String planning;

    @OneToMany(mappedBy = "coach")
    private List<Entrainement> entrainements;

    public void planifierSession() {
    }
}
