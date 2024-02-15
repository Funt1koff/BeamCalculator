package ru.TechStud.BeamCalculator.domain.sample;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.TechStud.BeamCalculator.domain.section.Section;

import java.util.List;

@Data
@NoArgsConstructor
public class SetSections {
    private List<Section> sections;

    @Getter
    private int numberSections = sections.size();
}
