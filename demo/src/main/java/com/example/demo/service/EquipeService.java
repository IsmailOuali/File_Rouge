package com.example.demo.service;

import com.example.demo.dto.request.EquipeRequestDTO;
import com.example.demo.dto.response.EquipeResponseDTO;

import java.util.List;

public interface EquipeService {
    EquipeResponseDTO createEquipe(EquipeRequestDTO equipeRequestDTO);
    EquipeResponseDTO getEquipeById(Long id);
    List<EquipeResponseDTO> getAllEquipes();
    EquipeResponseDTO updateEquipe(Long id, EquipeRequestDTO equipeRequestDTO);
    void deleteEquipe(Long id);
}