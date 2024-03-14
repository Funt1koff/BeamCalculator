package ru.TechStud.BeamCalculator.domain.load;

public class Moment extends LoadConcentrated {

    public Moment() {
        super.setIDENTIFIER(MOMENT);
    }

    public Moment(Double coordinate, Double value) {
        super.setCoordinate(coordinate);
        super.setValue(value);
        super.setIDENTIFIER(MOMENT);
    }

    @Override
    public void setIDENTIFIER(Integer IDENTIFIER) {

    }
}
