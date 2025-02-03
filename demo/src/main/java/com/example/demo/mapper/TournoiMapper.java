package com.example.demo.mapper;

import com.example.demo.dto.request.TournoiRequestDTO;
import com.example.demo.dto.response.TournoiResponseDTO;
import com.example.demo.entity.Tournoi;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TournoiMapper {

    Tournoi toEntity(TournoiRequestDTO tournoiRequestDTO);

    TournoiResponseDTO toResponseDTO(Tournoi tournoi);

    void updateEntityFromDTO(TournoiRequestDTO tournoiRequestDTO, @MappingTarget Tournoi tournoi);
}
