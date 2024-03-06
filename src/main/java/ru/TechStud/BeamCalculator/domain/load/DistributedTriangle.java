package ru.TechStud.BeamCalculator.domain.load;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class DistributedTriangle  extends LoadDistributed   {

    public DistributedTriangle(Double valueOnUnitLength,
                               Double coordinateStart,
                               Double coordinateEnd)    {
        super(valueOnUnitLength, coordinateStart, coordinateEnd);
        super.setIDENTIFIER(DISTRIBUTED_TRIANGLE);
        super.setCoordinateCenterMass(0.666667 * (coordinateEnd - coordinateStart));
        super.setValueEquivalent(0.5 * valueOnUnitLength * (coordinateEnd - coordinateStart));
    }

    @Override
    public void setCoordinateCenterMass(Double coordinateCenterMass) {

    }

    @Override
    public void setValueEquivalent(Double valueEquivalent)  {

    }

}
