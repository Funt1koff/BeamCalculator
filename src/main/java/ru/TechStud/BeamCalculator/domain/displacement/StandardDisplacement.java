package ru.TechStud.BeamCalculator.domain.displacement;

import lombok.Data;

@Data
public class StandardDisplacement implements Displacement  {

    private Integer IDENTIFIER;
    private Double coordinate;

    public StandardDisplacement(Double coordinate)  {
        IDENTIFIER = STANDARD;
    }
}
