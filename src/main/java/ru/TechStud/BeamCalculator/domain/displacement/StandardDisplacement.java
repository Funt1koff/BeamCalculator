package ru.TechStud.BeamCalculator.domain.displacement;

import lombok.*;

@Getter
@Setter
public class StandardDisplacement extends Displacement {
    boolean isMovable;

    public StandardDisplacement(double coordinate, boolean isMovable) {
        super(coordinate);
        this.isMovable = isMovable;
    }
}
