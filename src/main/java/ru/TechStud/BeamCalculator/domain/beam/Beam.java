package ru.TechStud.BeamCalculator.domain.beam;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Beam {
    private Double length;
    private Double area;
    private Double inertiaX;
    private Double inertiaY;
}
