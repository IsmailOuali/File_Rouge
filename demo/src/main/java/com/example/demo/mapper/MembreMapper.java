package com.example.demo.mapper;

import com.example.demo.dto.request.MembreRequestDTO;
import com.example.demo.dto.response.MembreResponseDTO;
import com.example.demo.entity.Membre;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MembreMapper {

    Membre toEntity(MembreRequestDTO membreRequestDTO);

    MembreResponseDTO toResponseDTO(Membre membre);

    void updateEntityFromDTO(MembreRequestDTO membreRequestDTO, @MappingTarget Membre membre);
}
