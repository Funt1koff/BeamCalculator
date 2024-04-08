package ru.TechStud.BeamCalculator.domain.section;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Section {

    private Double coordinate;
    private Boolean isLoad = false;
    private Boolean isDisplacement = false;

}
