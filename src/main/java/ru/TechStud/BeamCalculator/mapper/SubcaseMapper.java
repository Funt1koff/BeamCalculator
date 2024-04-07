package ru.TechStud.BeamCalculator.mapper;

import org.mapstruct.Mapper;
import ru.TechStud.BeamCalculator.dto.SubcaseDTO;
import ru.TechStud.BeamCalculator.entity.Subcase;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubcaseMapper {

    SubcaseDTO toDTO(Subcase entity);

    Subcase toEntity(SubcaseDTO dto);

    List<Subcase> toEntities(List<SubcaseDTO> dtos);

    List<SubcaseDTO> toDTOs(List<Subcase> entities);
}
