package ru.TechStud.BeamCalculator.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.TechStud.BeamCalculator.dto.BeamDTO;
import ru.TechStud.BeamCalculator.entity.Beam;
import ru.TechStud.BeamCalculator.mapper.BeamMapper;
import ru.TechStud.BeamCalculator.repository.BeamRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Data
@Slf4j
public class BeamService {

    private final BeamRepository beamRepository;
    private final BeamMapper beamMapper;

    public List<BeamDTO> getAll()  {
        log.info("Service {}, method 'getAll' started", BeamService.class.getName());
        return beamMapper.toDTOs(beamRepository.findAll());
    }

    @Transactional
    public BeamDTO create(BeamDTO dto)   {
        log.info("Service {}, method 'create' started with {}", BeamService.class.getName(), dto);
        return beamMapper.toDTO(beamRepository.save(beamMapper.toEntity(dto)));
    }

    @Transactional
    public BeamDTO update(BeamDTO dto)   {
        log.info("Service {}, method 'update' started with {}", BeamService.class.getName(), dto);
        return beamMapper.toDTO(beamRepository.save(beamMapper.toEntity(dto)));
    }

    public void deleteById(Long id) {
        log.info("Service {}, method 'delete' started with {}", BeamService.class.getName(), id);
        beamRepository.deleteById(id);
    }
}
