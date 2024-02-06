package ru.TechStud.BeamCalculator.Core.Force;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Getter
@Setter
public class RectangleDistributedForce extends DistributedForce {

    private double CenterMassCoord = (getEndCoordinate() + getStartCoordinate()) / 2;

}
