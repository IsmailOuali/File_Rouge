package com.example.demo.service.Impl;

import com.example.demo.dto.request.TournoiRequestDTO;
import com.example.demo.dto.response.TournoiResponseDTO;
import com.example.demo.entity.Tournoi;
import com.example.demo.mapper.TournoiMapper;
import com.example.demo.repository.TournoiRepository;
import com.example.demo.service.TournoiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TournoiServiceImpl implements TournoiService {

    private final TournoiRepository tournoiRepository;
    private final TournoiMapper tournoiMapper;

    @Override
    public TournoiResponseDTO createTournoi(TournoiRequestDTO tournoiRequestDTO) {
        Tournoi tournoi = tournoiMapper.toEntity(tournoiRequestDTO);
        tournoi = tournoiRepository.save(tournoi);
        return tournoiMapper.toResponseDTO(tournoi);
    }

    @Override
    public TournoiResponseDTO getTournoiById(Long id) {
        Tournoi tournoi = tournoiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tournoi not found"));
        return tournoiMapper.toResponseDTO(tournoi);
    }

    @Override
    public List<TournoiResponseDTO> getAllTournois() {
        return tournoiRepository.findAll().stream()
                .map(tournoiMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TournoiResponseDTO updateTournoi(Long id, TournoiRequestDTO tournoiRequestDTO) {
        Tournoi tournoi = tournoiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tournoi not found"));
        tournoiMapper.updateEntityFromDTO(tournoiRequestDTO, tournoi);
        tournoi = tournoiRepository.save(tournoi);
        return tournoiMapper.toResponseDTO(tournoi);
    }

    @Override
    public void deleteTournoi(Long id) {
        tournoiRepository.deleteById(id);
    }
}
