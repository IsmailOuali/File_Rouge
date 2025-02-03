package com.example.demo.service.Impl;

import com.example.demo.dto.request.MembreRequestDTO;
import com.example.demo.dto.response.MembreResponseDTO;
import com.example.demo.entity.Membre;
import com.example.demo.mapper.MembreMapper;
import com.example.demo.repository.MembreRepository;
import com.example.demo.service.MembreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MembreServiceImpl implements MembreService {

    private final MembreRepository membreRepository;
    private final MembreMapper membreMapper;

    @Override
    public MembreResponseDTO createMembre(MembreRequestDTO membreRequestDTO) {
        Membre membre = membreMapper.toEntity(membreRequestDTO);
        membre = membreRepository.save(membre);
        return membreMapper.toResponseDTO(membre);
    }

    @Override
    public MembreResponseDTO getMembreById(Long id) {
        Membre membre = membreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Membre not found"));
        return membreMapper.toResponseDTO(membre);
    }

    @Override
    public List<MembreResponseDTO> getAllMembres() {
        return membreRepository.findAll().stream()
                .map(membreMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MembreResponseDTO updateMembre(Long id, MembreRequestDTO membreRequestDTO) {
        Membre membre = membreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Membre not found"));
        membreMapper.updateEntityFromDTO(membreRequestDTO, membre);
        membre = membreRepository.save(membre);
        return membreMapper.toResponseDTO(membre);
    }

    @Override
    public void deleteMembre(Long id) {
        membreRepository.deleteById(id);
    }
}
