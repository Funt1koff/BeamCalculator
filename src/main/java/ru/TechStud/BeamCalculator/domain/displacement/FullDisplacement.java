package ru.TechStud.BeamCalculator.domain.displacement;

import lombok.Data;

@Data
public class FullDisplacement implements Displacement {

    private Integer IDENTIFIER;
    private Boolean isLeft = true;
    private Double coordinate = 0.0;

    public FullDisplacement() {
        IDENTIFIER = FULL;
    }

    public FullDisplacement(boolean isLeft) {
        this.isLeft = isLeft;
        IDENTIFIER = FULL;
    }
}
