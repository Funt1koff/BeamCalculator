package ru.TechStud.BeamCalculator.Core.Force;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class TriangleDistributedForce extends DistributedForce  {

    @Setter
    @Getter
    private double startValueForce;

    @Getter
    @Setter
    private double endValueForce;

    private final boolean isPositiveDerivative =  startValueForce < endValueForce;

    public double getCenterMassCoordinate() {
        if(isPositiveDerivative)
            return  2.0 / 3.0 * (endValueForce - startValueForce);
        else
            return 1.0 / 3.0 * (endValueForce - startValueForce);
    }
}
