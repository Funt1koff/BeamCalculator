package ru.TechStud.BeamCalculator.domain.load;

import org.springframework.beans.factory.annotation.Autowired;

public class Moment extends LoadConcentrated {

    @Autowired
    public Moment() {
        super.setIDENTIFIER(MOMENT);
    }

    @Autowired
    public Moment(Double coordinate, Double value) {
        super.setCoordinate(coordinate);
        super.setValue(value);
        super.setIDENTIFIER(MOMENT);
    }

    @Override
    public void setIDENTIFIER(Integer IDENTIFIER) {

    }
}
