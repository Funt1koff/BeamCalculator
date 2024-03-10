package ru.TechStud.BeamCalculator.domain.load;

import org.springframework.beans.factory.annotation.Autowired;

public class Force extends LoadConcentrated {

    @Autowired
    public Force() {
        super.setIDENTIFIER(FORCE);
    }

    @Autowired
    public Force(Double coordinate, Double value) {
        super.setCoordinate(coordinate);
        super.setValue(value);
        super.setIDENTIFIER(FORCE);
    }
}
