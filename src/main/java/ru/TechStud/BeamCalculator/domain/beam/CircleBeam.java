package ru.TechStud.BeamCalculator.domain.beam;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class CircleBeam extends Beam {

    private double radius;
    private double diameter = 2 * radius;

    public CircleBeam(double radius)    {
        this.setArea(
                PI * pow(radius, 2)
        );

        this.setInertiaX(
                PI * pow(diameter, 4) / 64
        );

        this.setInertiaY(
                PI * pow(diameter, 4) / 64
        );
    }
}
