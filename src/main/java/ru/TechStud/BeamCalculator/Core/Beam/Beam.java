package ru.TechStud.BeamCalculator.Core.Beam;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Beam {

    private static final double E = 2000000000000L;

    private long beamId;
    private double area;
    private double inertiaX;
    private double inertiaY;

}
