package com.example.demo.service.Impl;

import com.example.demo.dto.request.CoachRequestDTO;
import com.example.demo.dto.response.CoachResponseDTO;
import com.example.demo.entity.Coach;
import com.example.demo.mapper.CoachMapper;
import com.example.demo.repository.CoachRepository;
import com.example.demo.service.CoachService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CoachServiceImpl implements CoachService {

    private final CoachRepository coachRepository;
    private final CoachMapper coachMapper;

    @Override
    public CoachResponseDTO createCoach(CoachRequestDTO coachRequestDTO) {
        Coach coach = coachMapper.toEntity(coachRequestDTO);
        coach = coachRepository.save(coach);
        return coachMapper.toResponseDTO(coach);
    }

    @Override
    public CoachResponseDTO getCoachById(Long id) {
        Coach coach = coachRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Coach not found"));
        return coachMapper.toResponseDTO(coach);
    }

    @Override
    public List<CoachResponseDTO> getAllCoaches() {
        return coachRepository.findAll().stream()
                .map(coachMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CoachResponseDTO updateCoach(Long id, CoachRequestDTO coachRequestDTO) {
        Coach coach = coachRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Coach not found"));
        coachMapper.updateEntityFromDTO(coachRequestDTO, coach);
        coach = coachRepository.save(coach);
        return coachMapper.toResponseDTO(coach);
    }

    @Override
    public void deleteCoach(Long id) {
        coachRepository.deleteById(id);
    }
}