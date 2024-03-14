package ru.TechStud.BeamCalculator.domain.subcase;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.TechStud.BeamCalculator.domain.beam.Beam;
import ru.TechStud.BeamCalculator.domain.util.DisplacementList;
import ru.TechStud.BeamCalculator.domain.util.LoadList;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Subcase {

    private Beam beam;
    private LoadList loadList;
    private DisplacementList displacementList;

}
