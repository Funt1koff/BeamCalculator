package ru.TechStud.BeamCalculator.domain.load;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class LoadConcentrated implements Load {

    private Double coordinate;
    private Double value;
}
