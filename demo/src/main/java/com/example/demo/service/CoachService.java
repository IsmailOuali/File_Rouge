package com.example.demo.service;


import com.example.demo.dto.request.CoachRequestDTO;
import com.example.demo.dto.response.CoachResponseDTO;
import java.util.List;

public interface CoachService {
    CoachResponseDTO createCoach(CoachRequestDTO coachRequestDTO);
    CoachResponseDTO getCoachById(Long id);
    List<CoachResponseDTO> getAllCoaches();
    CoachResponseDTO updateCoach(Long id, CoachRequestDTO coachRequestDTO);
    void deleteCoach(Long id);
}
