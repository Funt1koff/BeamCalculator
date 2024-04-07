package ru.TechStud.BeamCalculator.mapper;

import org.mapstruct.Mapper;
import ru.TechStud.BeamCalculator.dto.DisplacementDTO;
import ru.TechStud.BeamCalculator.entity.Displacement;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DisplacementMapper {

    Displacement toEntity(DisplacementDTO dto);

    DisplacementDTO toDTO(Displacement entity);

    List<DisplacementDTO> toDTOs(List<Displacement> entities);

    List<Displacement> toEntities(List<DisplacementDTO> dtos);
}
