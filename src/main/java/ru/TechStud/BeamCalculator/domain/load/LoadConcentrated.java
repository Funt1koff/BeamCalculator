package ru.TechStud.BeamCalculator.domain.load;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@Data
@RequiredArgsConstructor
public abstract class LoadConcentrated implements Load {

    private Integer IDENTIFIER;
    private Double coordinate;
    private Double value;

    @Override
    public String toString() {

        return this.getClass().getName() +
                "\n" +
                "IDENTIFIER = " + this.getIDENTIFIER() +
                "\n" +
                "Coordinate = " + this.getCoordinate() +
                "\n" +
                "Value = " + this.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(IDENTIFIER, coordinate, value);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof LoadConcentrated)
            return (int) this.getIDENTIFIER() == ((LoadConcentrated) object).getIDENTIFIER() &&
                    Double.compare(this.getCoordinate(), ((LoadConcentrated) object).getCoordinate()) == 0 &&
                    Double.compare(this.getValue(), ((LoadConcentrated) object).getValue()) == 0;
        else
            return false;
    }
}
