package ru.TechStud.BeamCalculator.domain.result;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Result {

    private Double coordinate;
    private Double valueCrossForce;
    private Double valueBendingMoment;
    private Boolean isBorderLoad = false;
    private Boolean isDisplacement = false;

}
