package ru.TechStud.BeamCalculator.domain.load;

import lombok.Data;

import java.util.Objects;

@Data
public abstract class LoadDistributed implements Load {

    private Integer IDENTIFIER;
    private Double valueOnUnitLength;
    private Double coordinateStart;
    private Double coordinateEnd;
    private Double valueEquivalent;
    private Double coordinateCenterMass;

    public LoadDistributed(Double valueOnUnitLength, Double coordinateStart, Double coordinateEnd) {
        this.valueOnUnitLength = valueOnUnitLength;
        this.coordinateStart = coordinateStart;
        this.coordinateEnd = coordinateEnd;
    }

    @Override
    public String toString() {
        return this.getClass().getName() +
                "\n" +
                "IDENTIFIER = " +
                this.getIDENTIFIER() +
                "\n" +
                "ValueOnUnitLength = " +
                this.getValueEquivalent() +
                "\n" +
                "CoordinateStart = " +
                this.getCoordinateStart() +
                "\n" +
                "CoordinateEnd = " +
                this.getCoordinateEnd() +
                "\n" +
                "ValueEquivalent = " +
                this.getValueEquivalent() +
                "\n" +
                "CoordinateCenterMass = " +
                this.getCoordinateCenterMass();
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                IDENTIFIER,
                valueOnUnitLength,
                coordinateStart,
                coordinateEnd,
                valueEquivalent,
                coordinateCenterMass);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof LoadDistributed) {
            return
                    (int) this.getIDENTIFIER() == ((LoadDistributed) object).IDENTIFIER &&
                            Double.compare(this.valueOnUnitLength, ((LoadDistributed) object).valueOnUnitLength) == 0 &&
                            Double.compare(this.coordinateStart, ((LoadDistributed) object).getCoordinateStart()) == 0 &&
                            Double.compare(this.coordinateEnd, ((LoadDistributed) object).getCoordinateEnd()) == 0 &&
                            Double.compare(this.valueEquivalent, ((LoadDistributed) object).valueEquivalent) == 0 &&
                            Double.compare(this.getCoordinateCenterMass(),
                                    ((LoadDistributed) object).getCoordinateCenterMass()) == 0;

        } else
            return false;
    }
}
