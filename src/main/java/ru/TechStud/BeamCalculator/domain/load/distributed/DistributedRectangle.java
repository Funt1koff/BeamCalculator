package ru.TechStud.BeamCalculator.domain.load.distributed;

import lombok.NoArgsConstructor;
import ru.TechStud.BeamCalculator.domain.load.Distributed;

@NoArgsConstructor
public class DistributedRectangle extends Distributed {

    public DistributedRectangle(double valuePerLength, double coordinateStart, double coordinateEnd)    {
        super(valuePerLength, coordinateStart, coordinateEnd);
        this.setCoordinate(
                (coordinateStart + coordinateEnd) / 2
        );

        this.setValue(
                valuePerLength * (coordinateEnd - coordinateStart)
        );
    }

    @Override
    public void setCoordinate(double coordinate) {
    }

    @Override
    public void setValue(double value) {

    }

}
