package ru.TechStud.BeamCalculator.domain.result;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class Reaction {

    private Double coordinate;
    private Double value;

}
