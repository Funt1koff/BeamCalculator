package ru.TechStud.BeamCalculator.domain.sample;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.TechStud.BeamCalculator.domain.beam.Beam;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sample {

    private Date date;
    private Beam beam;
    private SetLoad setLoad;
    private SetDisplacements setDisplacements;
    private SetSections setSections;

}
