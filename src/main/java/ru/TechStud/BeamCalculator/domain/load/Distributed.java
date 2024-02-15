package ru.TechStud.BeamCalculator.domain.load;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public abstract class Distributed extends Load {
    private double valuePerLength;
    private double coordinateStart;
    private double coordinateEnd;
}
