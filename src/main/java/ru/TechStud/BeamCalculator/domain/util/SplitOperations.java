package ru.TechStud.BeamCalculator.domain.util;

import ru.TechStud.BeamCalculator.domain.section.Section;
import ru.TechStud.BeamCalculator.domain.subcase.Subcase;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static ru.TechStud.BeamCalculator.domain.util.LoadOperations.*;

public abstract class SplitOperations {

    public static final Integer QUANTITY_SITES_BEAM = 100;

    public static List<Section> getSections(Subcase subcase) {

        Double beamLength = subcase.getBeam().getLength();
        double incrementLength = beamLength / QUANTITY_SITES_BEAM;

        List<Section> sections = new ArrayList<>();

        for (int i = 0; i <= QUANTITY_SITES_BEAM; i++)
            sections.add(new Section(i * incrementLength, false, false));

        sections.addAll(getLoadConcentratedSections(subcase.getForces()));
        sections.addAll(getLoadConcentratedSections(subcase.getMoments()));
        sections.addAll(getLoadDistributedSections(subcase.getDistributedRectangles()));
        sections.addAll(getDisplacementSections(subcase.getDisplacements()));

        sections.sort(
                (coordinate1, coordinate2) -> {
                    if (coordinate1.getCoordinate() > coordinate2.getCoordinate())
                        return 1;
                    else if (coordinate1.getCoordinate() < coordinate2.getCoordinate())
                        return -1;
                    else
                        return 0;
                }
        );

        removeDuplicates(sections);

        return sections;
    }

    private static void removeDuplicates(List<Section> sections) {

        for (int i = 1; i < sections.size(); i++)
            if (Objects.equals(sections.get(i).getCoordinate(), sections.get(i - 1).getCoordinate()) &
                    !sections.get(i).getIsDisplacement())
                if (sections.get(i).getIsLoad() & sections.get(i).getIsDisplacement())
                    sections.remove(i - 1);
                else
                    sections.remove(i);

        while (true) {
            int marker = 0;
            for (int i = 1; i < sections.size(); i++) {
                if ((Objects.equals(sections.get(i - 1).getCoordinate(), sections.get(i).getCoordinate()) &

                        Objects.equals(sections.get(i).getCoordinate(), sections.get(i + 1).getCoordinate())) &

                        (sections.get(i - 1).getIsLoad() & sections.get(i).getIsLoad()) ||
                        (sections.get(i).getIsLoad() & sections.get(i + 1).getIsLoad())) {

                    sections.remove(i);
                    marker++;
                }
            }
            if (marker == 0)
                break;
        }

        for (int i = 0; i < sections.size() - 1; i++) {
            if (sections.get(i).getIsDisplacement() & sections.get(i + 1).getIsLoad() ||
                    sections.get(i).getIsLoad() & sections.get(i + 1).getIsDisplacement()) {
                Double temp = sections.get(i).getCoordinate();
                sections.remove(i);
                sections.remove(i);
                sections.add(i, new Section(temp, true, true));
            }
        }

    }
}
