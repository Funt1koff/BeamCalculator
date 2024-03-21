package ru.TechStud.BeamCalculator.domain.section;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class Section {

    private Double coordinate;
    private Boolean isLoad = false;
    private Boolean isDisplacement = false;

    public Section(Double coordinate) {
        this.coordinate = coordinate;
    }

    public Section(Double coordinate, Boolean isLoad) {
        this.coordinate = coordinate;
        this.isLoad = isLoad;
    }

    public Section(Double coordinate, Boolean isLoad, Boolean isDisplacement) {
        this.coordinate = coordinate;
        this.isLoad = isLoad;
        this.isDisplacement = isDisplacement;
    }


}
