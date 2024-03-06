package ru.TechStud.BeamCalculator.domain.load;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public abstract class LoadDistributed implements Load    {

    private Integer IDENTIFIER;
    private Double valueOnUnitLength;
    private Double coordinateStart;
    private Double coordinateEnd;
    private Double valueEquivalent;
    private Double coordinateCenterMass;

    public LoadDistributed(Double valueOnUnitLength, Double coordinateStart, Double coordinateEnd) {
        this.valueOnUnitLength = valueOnUnitLength;
        this.coordinateStart = coordinateStart;
        this.coordinateEnd = coordinateEnd;
    }
}
