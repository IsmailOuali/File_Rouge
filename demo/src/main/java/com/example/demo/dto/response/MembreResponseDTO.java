package com.example.demo.dto.response;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class MembreResponseDTO {
    private Long id;
    private String nom;
    private String email;
    private String abonnement;
    private String status;
    private LocalDateTime dateInscription;
}