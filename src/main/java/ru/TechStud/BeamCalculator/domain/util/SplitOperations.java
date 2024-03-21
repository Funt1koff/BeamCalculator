package ru.TechStud.BeamCalculator.domain.util;

import ru.TechStud.BeamCalculator.domain.section.Section;
import ru.TechStud.BeamCalculator.domain.subcase.Subcase;

import java.util.ArrayList;
import java.util.List;

import static ru.TechStud.BeamCalculator.domain.config.CalculatorConfig.QUANTITY_SITES_BEAM;

//For future
public abstract class SplitOperations {

    public static List<Section> getSections(Subcase subcase) {

        Double beamLength = subcase.getBeam().getLength();
        double incrementLength = beamLength / QUANTITY_SITES_BEAM;

        List<Section> loadSections = subcase.getLoadList().getLoadSections();

        List<Section> sections = new ArrayList<>();

        for (int i = 0; i <= QUANTITY_SITES_BEAM; i++)
            sections.add(new Section(i * incrementLength));

        sections.addAll(loadSections);
        sections.addAll(subcase.getDisplacementList().getDisplacementSections());

        sections.sort(
                (coordinate1, coordinate2) -> {
                    if (coordinate1.getCoordinate() > coordinate2.getCoordinate())
                        return 1;
                    else if (coordinate1.getCoordinate() < coordinate2.getCoordinate())
                        return -1;
                    else return 0;
                }
        );

        ArraysOperation.removeDuplicates(sections);

        return sections;
    }
}