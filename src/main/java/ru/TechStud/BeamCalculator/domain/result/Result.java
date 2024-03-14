package ru.TechStud.BeamCalculator.domain.result;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Result {

    private Double coordinate;
    private Double valueForceCross;
    private Double valueMomentBending;
    private Boolean isBorderLoad = false;
    private Boolean isDisplacement = false;

}
