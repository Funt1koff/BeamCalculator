package ru.TechStud.BeamCalculator.domain.load;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@ToString
public class Moment extends LoadConcentrated {

    public Moment(Double coordinate, Double value) {
        super(coordinate, value);
    }

}
