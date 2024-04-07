package ru.TechStud.BeamCalculator.mapper;

import org.mapstruct.Mapper;
import ru.TechStud.BeamCalculator.dto.DistributedRectangleDTO;
import ru.TechStud.BeamCalculator.entity.DistributedRectangle;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DistributedRectangleMapper {

    DistributedRectangle toEntity(DistributedRectangleDTO dto);

    DistributedRectangleDTO toDTO(DistributedRectangle entity);

    List<DistributedRectangle> toEntities(List<DistributedRectangleDTO> dtos);

    List<DistributedRectangleDTO> toDTOs(List<DistributedRectangle> entities);
}
