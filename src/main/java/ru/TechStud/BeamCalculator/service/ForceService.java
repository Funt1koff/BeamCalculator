package ru.TechStud.BeamCalculator.service;


import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.TechStud.BeamCalculator.dto.ForceDTO;
import ru.TechStud.BeamCalculator.mapper.ForceMapper;
import ru.TechStud.BeamCalculator.repository.ForceRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Data
@Slf4j
public class ForceService {

    private final ForceRepository forceRepository;
    private final ForceMapper forceMapper;

    public List<ForceDTO> getAll() {
        log.info("Service {}, method 'getAll' started", ForceService.class.getName());
        return forceMapper.toDTOs(forceRepository.findAll());
    }

    @Transactional
    public ForceDTO create(ForceDTO dto) {
        log.info("Service {}, method 'create' started with {}", ForceService.class.getName(), dto);
        return forceMapper.toDTO(forceRepository.save(forceMapper.toEntity(dto)));
    }

    @Transactional
    public ForceDTO update(ForceDTO dto) {
        log.info("Service {}, method 'update' started with {}", ForceService.class.getName(), dto);
        return forceMapper.toDTO(forceRepository.save(forceMapper.toEntity(dto)));
    }

    public void delete(Long id) {
        log.info("Service {}, method 'delete' started with {}", ForceService.class.getName(), id);
        forceRepository.deleteById(id);
    }
}
