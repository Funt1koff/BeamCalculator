package ru.TechStud.BeamCalculator.domain.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    private Double coordinate;
    private Double valueForceCross;
    private Double valueMomentBending;

}
