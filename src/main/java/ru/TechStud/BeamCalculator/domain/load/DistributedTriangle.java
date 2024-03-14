package ru.TechStud.BeamCalculator.domain.load;

import org.springframework.beans.factory.annotation.Autowired;

public class DistributedTriangle extends LoadDistributed {

    @Autowired
    public DistributedTriangle(Double valueOnUnitLength,
                               Double coordinateStart,
                               Double coordinateEnd) {
        super(valueOnUnitLength, coordinateStart, coordinateEnd);
        super.setIDENTIFIER(DISTRIBUTED_TRIANGLE);
        super.setCoordinateCenterMass(
                coordinateStart + 0.666667 * (coordinateEnd - coordinateStart));
        super.setValueEquivalent(0.5 * valueOnUnitLength * (coordinateEnd - coordinateStart));
    }

    @Override
    public void setCoordinateCenterMass(Double coordinateCenterMass) {

    }

    @Override
    public void setValueEquivalent(Double valueEquivalent) {

    }

}
