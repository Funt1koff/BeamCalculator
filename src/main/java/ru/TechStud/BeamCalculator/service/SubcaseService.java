package ru.TechStud.BeamCalculator.service;


import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.TechStud.BeamCalculator.dto.SubcaseDTO;
import ru.TechStud.BeamCalculator.entity.Subcase;
import ru.TechStud.BeamCalculator.mapper.SubcaseMapper;
import ru.TechStud.BeamCalculator.repository.SubcaseRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Data
@Slf4j
public class SubcaseService {

    private final SubcaseRepository subcaseRepository;
    private final SubcaseMapper subcaseMapper;

    public List<SubcaseDTO> getAll()    {
        log.info("Service {}, method 'getAll' started", SubcaseService.class.getName());
        return subcaseMapper.toDTOs(subcaseRepository.findAll());
    }

    @Transactional
    public SubcaseDTO create(SubcaseDTO dto) {
        log.info("Service {}, method 'create' started with {}", SubcaseService.class.getName(), dto);
        return subcaseMapper.toDTO(subcaseRepository.save(subcaseMapper.toEntity(dto)));
    }

    @Transactional
    public SubcaseDTO update(SubcaseDTO dto)   {
        log.info("Service {}, method 'update' started with {}", SubcaseService.class.getName(), dto);
        return subcaseMapper.toDTO(subcaseRepository.save(subcaseMapper.toEntity(dto)));
    }

    public void delete(Long id) {
        log.info("Service {}, method 'delete' started with {}", SubcaseService.class.getName(), id);
        subcaseRepository.deleteById(id);
    }
}
