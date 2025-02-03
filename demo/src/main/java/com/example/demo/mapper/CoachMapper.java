package com.example.demo.mapper;

import com.example.demo.dto.request.CoachRequestDTO;
import com.example.demo.dto.response.CoachResponseDTO;
import com.example.demo.entity.Coach;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CoachMapper {

    Coach toEntity(CoachRequestDTO coachRequestDTO);

    CoachResponseDTO toResponseDTO(Coach coach);

    void updateEntityFromDTO(CoachRequestDTO coachRequestDTO, @MappingTarget Coach coach);
}
