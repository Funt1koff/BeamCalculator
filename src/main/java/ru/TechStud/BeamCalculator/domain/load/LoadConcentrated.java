package ru.TechStud.BeamCalculator.domain.load;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public abstract class LoadConcentrated implements Load {

    private Integer IDENTIFIER;
    private Double coordinate;
    private Double value;

}
