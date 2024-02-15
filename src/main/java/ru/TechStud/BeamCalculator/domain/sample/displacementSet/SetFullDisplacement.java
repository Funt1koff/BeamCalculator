package ru.TechStud.BeamCalculator.domain.sample.displacementSet;

import lombok.Getter;
import ru.TechStud.BeamCalculator.domain.displacement.FullDisplacement;

import java.util.ArrayList;
import java.util.List;
@Getter
public class SetFullDisplacement {
    private final List<FullDisplacement> displacements = new ArrayList<>();

    public SetFullDisplacement(boolean isLeft)  {
        displacements.add(new FullDisplacement(isLeft));
    }
}
