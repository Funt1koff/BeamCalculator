package ru.TechStud.BeamCalculator.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.TechStud.BeamCalculator.dto.DisplacementDTO;
import ru.TechStud.BeamCalculator.entity.Displacement;
import ru.TechStud.BeamCalculator.mapper.DisplacementMapper;
import ru.TechStud.BeamCalculator.repository.DisplacementRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Data
@Slf4j
public class DisplacementService {

    private final DisplacementRepository displacementRepository;
    private final DisplacementMapper displacementMapper;

    public List<DisplacementDTO> getAll() {
        log.info("Service {}, method 'getAll' started", DisplacementService.class.getName());
        return displacementMapper.toDTOs(displacementRepository.findAll());
    }

    @Transactional
    public DisplacementDTO create(DisplacementDTO dto) {
        log.info("Service {}, method 'create' started with {}", DisplacementService.class.getName(), dto);
        return displacementMapper
                .toDTO(displacementRepository
                        .save(displacementMapper
                                .toEntity(dto)));
    }

    @Transactional
    public DisplacementDTO update(DisplacementDTO dto) {
        log.info("Service {}, method 'update' started with {}", DisplacementService.class.getName(), dto);
        return displacementMapper
                .toDTO(displacementRepository
                        .save(displacementMapper
                                .toEntity(dto)));
    }

    public void delete(Long id) {
        log.info("Service {}, method 'delete' started with {}", DisplacementService.class.getName(), id);
        displacementRepository.deleteById(id);
    }
}
