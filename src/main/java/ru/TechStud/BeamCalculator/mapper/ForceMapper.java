package ru.TechStud.BeamCalculator.mapper;

import org.mapstruct.Mapper;
import ru.TechStud.BeamCalculator.dto.ForceDTO;
import ru.TechStud.BeamCalculator.entity.Force;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ForceMapper {

    Force toEntity(ForceDTO dto);

    ForceDTO toDTO(Force entity);

    List<Force> toEntities(List<ForceDTO> dtos);

    List<ForceDTO> toDTOs(List<Force> entities);
}
