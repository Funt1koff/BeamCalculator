package ru.TechStud.BeamCalculator.domain.displacement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FullDisplacement extends Displacement {
    private boolean isLeft;

    public FullDisplacement(boolean isLeft) {
        this.isLeft = isLeft;

        if(isLeft)
            setCoordinate(0);
        else
            setCoordinate(1);
    }
}
