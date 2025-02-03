package com.example.demo.service;

import com.example.demo.dto.request.TournoiRequestDTO;
import com.example.demo.dto.response.TournoiResponseDTO;

import java.util.List;

public interface TournoiService {
    TournoiResponseDTO createTournoi(TournoiRequestDTO tournoiRequestDTO);
    TournoiResponseDTO getTournoiById(Long id);
    List<TournoiResponseDTO> getAllTournois();
    TournoiResponseDTO updateTournoi(Long id, TournoiRequestDTO tournoiRequestDTO);
    void deleteTournoi(Long id);
}
