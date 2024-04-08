package ru.TechStud.BeamCalculator.domain.load;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@ToString
public class Force extends LoadConcentrated {

    public Force(Double coordinate, Double value) {
        super(coordinate, value);
    }
}
