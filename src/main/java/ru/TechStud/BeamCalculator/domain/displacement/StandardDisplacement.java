package ru.TechStud.BeamCalculator.domain.displacement;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class StandardDisplacement implements Displacement {

    private Integer IDENTIFIER;
    private Double coordinate;

    @Autowired
    public StandardDisplacement(Double coordinate) {
        IDENTIFIER = STANDARD;
    }
}
