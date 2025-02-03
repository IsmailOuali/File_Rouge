package com.example.demo.mapper;

import com.example.demo.dto.request.EquipeRequestDTO;
import com.example.demo.dto.response.EquipeResponseDTO;
import com.example.demo.entity.Equipe;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EquipeMapper {

    Equipe toEntity(EquipeRequestDTO equipeRequestDTO);

    EquipeResponseDTO toResponseDTO(Equipe equipe);

    void updateEntityFromDTO(EquipeRequestDTO equipeRequestDTO, @MappingTarget Equipe equipe);
}
