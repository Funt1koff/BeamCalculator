package ru.TechStud.BeamCalculator.Core.Force;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@RequiredArgsConstructor
public class DistributedForce extends Force {

    private double startCoordinate;
    private double endCoordinate;
}
