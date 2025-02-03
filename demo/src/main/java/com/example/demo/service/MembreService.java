package com.example.demo.service;

import com.example.demo.dto.request.MembreRequestDTO;
import com.example.demo.dto.response.MembreResponseDTO;
import java.util.List;

public interface MembreService {
    MembreResponseDTO createMembre(MembreRequestDTO membreRequestDTO);
    MembreResponseDTO getMembreById(Long id);
    List<MembreResponseDTO> getAllMembres();
    MembreResponseDTO updateMembre(Long id, MembreRequestDTO membreRequestDTO);
    void deleteMembre(Long id);
}