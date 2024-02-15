package ru.TechStud.BeamCalculator.domain.load;

import lombok.Data;

@Data
public abstract class Load {
    private double value;
    private double coordinate;
}
