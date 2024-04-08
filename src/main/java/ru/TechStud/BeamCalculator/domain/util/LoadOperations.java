package ru.TechStud.BeamCalculator.domain.util;

import ru.TechStud.BeamCalculator.domain.displacement.Displacement;
import ru.TechStud.BeamCalculator.domain.load.LoadConcentrated;
import ru.TechStud.BeamCalculator.domain.load.LoadDistributed;
import ru.TechStud.BeamCalculator.domain.section.Section;

import java.util.ArrayList;
import java.util.List;

public abstract class LoadOperations {

    public static List<Section> getLoadConcentratedSections(List<? extends LoadConcentrated> loads) {
        List<Section> sections = new ArrayList<>();

        for (LoadConcentrated load : loads) {
            sections.add(new Section(load.getCoordinate(), true, false));
            sections.add(new Section(load.getCoordinate(), true, false));
        }

        return sections;
    }

    public static List<Section> getLoadDistributedSections(List<? extends LoadDistributed> loads) {
        List<Section> sections = new ArrayList<>();

        for (LoadDistributed load : loads) {
            sections.add(new Section(load.getCoordinateStart(), true, false));
            sections.add(new Section(load.getCoordinateStart(), true, false));
            sections.add(new Section(load.getCoordinateEnd(), true, false));
            sections.add(new Section(load.getCoordinateEnd(), true, false));
        }

        return sections;
    }

    public static List<Section> getDisplacementSections(List<? extends Displacement> displacements)   {
        List<Section> sections = new ArrayList<>();

        for(Displacement displacement : displacements)  {
            sections.add(new Section(displacement.getCoordinate(), false, true));
            sections.add(new Section(displacement.getCoordinate(), false, true));
        }

        return sections;
    }
}
