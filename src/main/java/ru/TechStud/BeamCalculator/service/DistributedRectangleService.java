package ru.TechStud.BeamCalculator.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.TechStud.BeamCalculator.dto.DistributedRectangleDTO;
import ru.TechStud.BeamCalculator.entity.DistributedRectangle;
import ru.TechStud.BeamCalculator.mapper.DistributedRectangleMapper;
import ru.TechStud.BeamCalculator.repository.DistributedRectangleRepository;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
@Data
public class DistributedRectangleService {

    private final DistributedRectangleMapper distributedRectangleMapper;
    private final DistributedRectangleRepository distributedRectangleRepository;

    public List<DistributedRectangleDTO> getAll()   {
        log.info("Service {}, method 'getAll' started", DistributedRectangleService.class.getName());
        return distributedRectangleMapper.toDTOs(distributedRectangleRepository.findAll());
    }

    @Transactional
    public DistributedRectangleDTO create(DistributedRectangleDTO dto)  {
        log.info("Service {}, method 'create' started with {}", DistributedRectangleService.class.getName(), dto);
        return distributedRectangleMapper
                .toDTO(distributedRectangleRepository
                        .save(distributedRectangleMapper.toEntity(dto)));
    }

    @Transactional
    public DistributedRectangleDTO update(DistributedRectangleDTO dto)    {
        log.info("Service {}, method 'update' started with {}",
                DistributedRectangleService.class.getName(), dto);
        return distributedRectangleMapper
                .toDTO(distributedRectangleRepository
                        .save(distributedRectangleMapper.toEntity(dto)));
    }

    public void delete(Long id) {
        log.info("Service {}, method 'delete' started with {}", DistributedRectangleService.class.getName(), id);
        distributedRectangleRepository.deleteById(id);
    }

}
