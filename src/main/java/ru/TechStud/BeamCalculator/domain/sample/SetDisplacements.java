package ru.TechStud.BeamCalculator.domain.sample;

import lombok.Data;
import ru.TechStud.BeamCalculator.domain.displacement.Displacement;

import java.util.List;
@Data
public abstract class SetDisplacements {
    private List<Displacement> displacements;
}
