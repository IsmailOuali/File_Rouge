package com.example.demo.service.Impl;

import com.example.demo.dto.request.EquipeRequestDTO;
import com.example.demo.dto.response.EquipeResponseDTO;
import com.example.demo.entity.Equipe;
import com.example.demo.mapper.EquipeMapper;
import com.example.demo.repository.EquipeRepository;
import com.example.demo.service.EquipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EquipeServiceImpl implements EquipeService {

    private final EquipeRepository equipeRepository;
    private final EquipeMapper equipeMapper;

    @Override
    public EquipeResponseDTO createEquipe(EquipeRequestDTO equipeRequestDTO) {
        Equipe equipe = equipeMapper.toEntity(equipeRequestDTO);
        equipe = equipeRepository.save(equipe);
        return equipeMapper.toResponseDTO(equipe);
    }

    @Override
    public EquipeResponseDTO getEquipeById(Long id) {
        Equipe equipe = equipeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipe not found"));
        return equipeMapper.toResponseDTO(equipe);
    }

    @Override
    public List<EquipeResponseDTO> getAllEquipes() {
        return equipeRepository.findAll().stream()
                .map(equipeMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EquipeResponseDTO updateEquipe(Long id, EquipeRequestDTO equipeRequestDTO) {
        Equipe equipe = equipeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipe not found"));
        equipeMapper.updateEntityFromDTO(equipeRequestDTO, equipe);
        equipe = equipeRepository.save(equipe);
        return equipeMapper.toResponseDTO(equipe);
    }

    @Override
    public void deleteEquipe(Long id) {
        equipeRepository.deleteById(id);
    }
}