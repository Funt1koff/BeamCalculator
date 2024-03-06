package ru.TechStud.BeamCalculator.domain.load;

public class Force extends LoadConcentrated {

    public Force()  {
        super.setIDENTIFIER(FORCE);
    }

    public Force(Double coordinate, Double value)   {
        super.setCoordinate(coordinate);
        super.setValue(value);
        super.setIDENTIFIER(FORCE);
    }
}
