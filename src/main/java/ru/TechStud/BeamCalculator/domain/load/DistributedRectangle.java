package ru.TechStud.BeamCalculator.domain.load;


public class DistributedRectangle extends LoadDistributed {


    public DistributedRectangle(Double valueOnUnitLength,
                                Double coordinateStart,
                                Double coordinateEnd) {
        super(valueOnUnitLength, coordinateStart, coordinateEnd);
        super.setIDENTIFIER(DISTRIBUTED_RECTANGLE);
        super.setCoordinateCenterMass(
                coordinateStart + 0.5 * (coordinateEnd - coordinateStart));
        super.setValueEquivalent(valueOnUnitLength * (coordinateEnd - coordinateStart));
    }

    @Override
    public void setCoordinateCenterMass(Double coordinateCenterMass) {

    }

    @Override
    public void setValueEquivalent(Double valueEquivalent) {

    }
}
