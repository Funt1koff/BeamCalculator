package ru.TechStud.BeamCalculator.mapper;

import org.mapstruct.Mapper;
import ru.TechStud.BeamCalculator.dto.BeamDTO;
import ru.TechStud.BeamCalculator.entity.Beam;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BeamMapper {

    Beam toEntity(BeamDTO beamDTO);

    BeamDTO toDTO(Beam entity);

    List<Beam> toEntities(List<BeamDTO> dtos);

    List<BeamDTO> toDTOs(List<Beam> entities);
}
