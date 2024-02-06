package ru.TechStud.BeamCalculator.Core.Beam;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import static java.lang.Math.PI;
import static java.lang.Math.pow;

@Getter
@Setter
@Component
@NoArgsConstructor
public class CircleBeam extends Beam {

    private double radius;

    public CircleBeam(double radius)    {
        this.setArea(
                PI * pow(radius, 2)
        );

        this.setInertiaX(
                PI * pow(2 * radius, 4)
        );

        this.setInertiaY(
                PI * pow(2 * radius, 4)
        );
    }
}
