package ru.TechStud.BeamCalculator.domain.sample.displacementSet;

import lombok.Getter;
import ru.TechStud.BeamCalculator.domain.displacement.StandardDisplacement;

import java.util.ArrayList;
import java.util.List;

@Getter
public class SetStandardDisplacement {

    private final List<StandardDisplacement> displacements = new ArrayList<>();

    public SetStandardDisplacement(double coordinateDisplacement1, double coordinateDisplacement2)  {
        displacements.add(new StandardDisplacement(coordinateDisplacement1, true));
        displacements.add(new StandardDisplacement(coordinateDisplacement2, false));
    }
}
