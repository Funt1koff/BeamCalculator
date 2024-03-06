package ru.TechStud.BeamCalculator.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.TechStud.BeamCalculator.dto.LoadDTO;
import ru.TechStud.BeamCalculator.entity.Load;
import ru.TechStud.BeamCalculator.repository.LoadRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class LoadService {
    private final LoadRepository loadRepository;
    public Load create(LoadDTO dto)    {
        Load load = Load.builder()
                .coordinate(dto.getCoordinate())
                .value(dto.getValue())
                .build();
        return loadRepository.save(load);
    }

    public List<Load> readAll() {
        return loadRepository.findAll();
    }

    public Load update(Load load)   {
        return loadRepository.save(load);
    }

    public void delete(Long id) {
        loadRepository.deleteById(id);
    }
}
