package ru.TechStud.BeamCalculator.domain.beam;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public abstract class Beam {

    private static final double E = 2000000000000L;

    private long beamId;
    private double area;
    private double length;
    private double inertiaX;
    private double inertiaY;

}
