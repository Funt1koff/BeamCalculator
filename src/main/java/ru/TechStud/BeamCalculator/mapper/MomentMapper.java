package ru.TechStud.BeamCalculator.mapper;

import org.mapstruct.Mapper;
import ru.TechStud.BeamCalculator.dto.MomentDTO;
import ru.TechStud.BeamCalculator.entity.Moment;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MomentMapper {

    Moment toEntity(MomentDTO dto);

    MomentDTO toDTO(Moment entity);

    List<Moment> toEntities(List<MomentDTO> dtos);

    List<MomentDTO> toDTOs(List<Moment> entities);
}
