package ru.TechStud.BeamCalculator.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.TechStud.BeamCalculator.dto.BeamDTO;
import ru.TechStud.BeamCalculator.entity.Beam;
import ru.TechStud.BeamCalculator.repository.BeamRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class BeamService {

    private final BeamRepository beamRepository;

    public Beam create(BeamDTO dto) {
        Beam beam = Beam.builder()
                .length(dto.getLength())
                .area(dto.getArea())
                .inertiaX(dto.getInertiaX())
                .inertiaY(dto.getInertiaY())
                .build();

        return beamRepository.save(beam);
    }

    public List<Beam> readAll() {
        return beamRepository.findAll();
    }

    public Beam update(Beam beam)   {
        return beamRepository.save(beam);
    }

    public void delete(Long id) {
        beamRepository.deleteById(id);
    }
}
