package ru.TechStud.BeamCalculator.domain.subcase;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import ru.TechStud.BeamCalculator.domain.beam.Beam;
import ru.TechStud.BeamCalculator.domain.displacement.Displacement;
import ru.TechStud.BeamCalculator.domain.load.DistributedRectangle;
import ru.TechStud.BeamCalculator.domain.load.Force;
import ru.TechStud.BeamCalculator.domain.load.Moment;

import java.util.List;

@Data
@AllArgsConstructor
public class Subcase {

    private Beam beam;

    private List<Force> forces;
    private List<Moment> moments;
    private List<DistributedRectangle> distributedRectangles;

    private List<Displacement> displacements;
}
