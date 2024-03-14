package ru.TechStud.BeamCalculator.domain.util;

import ru.TechStud.BeamCalculator.domain.section.Section;

import java.util.List;
import java.util.Objects;

abstract class ArraysOperation {

    static void removeDuplicates(List<Section> sections) {

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

