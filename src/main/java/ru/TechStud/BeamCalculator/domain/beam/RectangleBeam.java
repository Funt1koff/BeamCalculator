package ru.TechStud.BeamCalculator.domain.beam;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import static java.lang.Math.pow;

@Getter
@Setter
@Component
@NoArgsConstructor
public class RectangleBeam extends Beam {

    private double height;
    private double width;

    public RectangleBeam(double height, double width)   {
        this.setArea(
                width * height
        );

        this.setInertiaX(
                width * pow(height, 2) / 32
        );

        this.setInertiaY(
                height * pow(width, 2) / 32
        );
    }
}
