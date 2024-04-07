package ru.TechStud.BeamCalculator.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.TechStud.BeamCalculator.dto.MomentDTO;
import ru.TechStud.BeamCalculator.entity.Moment;
import ru.TechStud.BeamCalculator.mapper.MomentMapper;
import ru.TechStud.BeamCalculator.repository.MomentRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Data
@Slf4j
public class MomentService {

    private final MomentRepository momentRepository;
    private final MomentMapper momentMapper;

    public List<MomentDTO> getAll() {
        log.info("Service {}, method 'getAll' started", MomentService.class.getName());
        return momentMapper.toDTOs(momentRepository.findAll());
    }

    @Transactional
    public MomentDTO create(MomentDTO dto) {
        log.info("Service {}, method 'create' started with {}", MomentService.class.getName(), dto);
        return momentMapper.toDTO(momentRepository.save(momentMapper.toEntity(dto)));
    }

    @Transactional
    public MomentDTO update(MomentDTO dto) {
        log.info("Service {}, method 'update' started with {}", MomentService.class.getName(), dto);
        return momentMapper.toDTO(momentRepository.save(momentMapper.toEntity(dto)));
    }

    public void delete(Long id) {
        log.info("Service {}, method 'delete' started with {}", MomentService.class.getName(), id);
        momentRepository.deleteById(id);
    }
}
