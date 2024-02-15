package ru.TechStud.BeamCalculator.domain.load.distributed;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import ru.TechStud.BeamCalculator.domain.load.Distributed;

@Getter
@Setter
@NoArgsConstructor
public class DistributedTriangle extends Distributed {
    private boolean isPositiveDerivative;

    @Autowired
    public DistributedTriangle(
            double valuePerLength,
            double coordinateStart,
            double coordinateEnd,
            boolean isPositiveDerivative)  {
        super(valuePerLength, coordinateStart, coordinateEnd);
        this.isPositiveDerivative = isPositiveDerivative;
        if(isPositiveDerivative)
            setCoordinate(0.6667 * (getCoordinateEnd() - getCoordinateStart()));
        else
            setCoordinate(0.3333 * (getCoordinateEnd() - getCoordinateStart()));

        setValue(
                0.5 * getValuePerLength() * (getCoordinateEnd() - getCoordinateStart())
        );
    }

    @Override
    public void setValue(double value) {
        super.setValue(
                0.5 * getValuePerLength() * (getCoordinateEnd() - getCoordinateStart())
        );
    }

    @Override
    public void setCoordinate(double coordinate) {

        if(isPositiveDerivative)
            super.setCoordinate(0.6667 * (getCoordinateEnd() - getCoordinateStart()));
        else
            super.setCoordinate(0.3333 * (getCoordinateEnd() - getCoordinateStart()));

        setValue(
                0.5 * getValuePerLength() * (getCoordinateEnd() - getCoordinateStart())
        );
    }
}
