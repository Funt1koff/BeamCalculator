package ru.TechStud.BeamCalculator.domain.load;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class DistributedRectangle extends LoadDistributed   {

    public DistributedRectangle(Double valueOnUnitLength,
                                Double coordinateStart,
                                Double coordinateEnd)   {
        super(valueOnUnitLength, coordinateStart, coordinateEnd);
        super.setIDENTIFIER(DISTRIBUTED_RECTANGLE);
        super.setCoordinateCenterMass(0.5 * (coordinateEnd - coordinateStart));
        super.setValueEquivalent(valueOnUnitLength * (coordinateEnd - coordinateStart));
    }

    @Override
    public void setCoordinateCenterMass(Double coordinateCenterMass) {

    }

    @Override
    public void setValueEquivalent(Double valueEquivalent) {

    }
}
