package ru.TechStud.BeamCalculator.domain.util;

import ru.TechStud.BeamCalculator.domain.section.Section;
import ru.TechStud.BeamCalculator.domain.subcase.Subcase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//For future
public abstract class SplitBeam {

    public static List<List<Section>> fullSplit(Subcase subcase) {

        List<List<Double>> sectionCoordinates = getSectionCoordinates(subcase);
        List<List<Section>> sites = new ArrayList<>();

        for (int i = 0; i < sectionCoordinates.size(); i++)
            sites.add(new ArrayList<>());

        for (int i = 0; i < sectionCoordinates.size(); i++)
            for (Double coordinate : sectionCoordinates.get(i))
                sites.get(i).add(new Section(coordinate));

        return sites;
    }

    private static Double[] getLoadCoordinates(Subcase subcase) {

        Double[] forceCoordinates = new Double[subcase.getLoadList().getForces().size()];
        Double[] momentCoordinates = new Double[subcase.getLoadList().getMoments().size()];
        Double[] distributedRectangleCoordinates = new Double[subcase.getLoadList().getDistributedsRectangle().size()];
        Double[] distributedTriangleCoordinates = new Double[subcase.getLoadList().getDistributedsTriangle().size()];

        for (int i = 0; i < forceCoordinates.length; i++)
            forceCoordinates[i] = subcase.getLoadList()
                    .getForces()
                    .get(i)
                    .getCoordinate();

        for (int i = 0; i < momentCoordinates.length; i++)
            momentCoordinates[i] = subcase.getLoadList().getMoments().get(i).getCoordinate();

        for (int i = 0; i < distributedRectangleCoordinates.length; i += 2) {
            distributedRectangleCoordinates[i] = subcase.getLoadList()
                    .getDistributedsRectangle()
                    .get(i)
                    .getCoordinateStart();

            distributedRectangleCoordinates[i + 1] = subcase.getLoadList()
                    .getDistributedsRectangle()
                    .get(i)
                    .getCoordinateEnd();
        }

        for (int i = 0; i < distributedTriangleCoordinates.length; i += 2) {
            distributedTriangleCoordinates[i] = subcase.getLoadList()
                    .getDistributedsTriangle()
                    .get(i)
                    .getCoordinateStart();

            distributedTriangleCoordinates[i + 1] = subcase.getLoadList()
                    .getDistributedsTriangle()
                    .get(i)
                    .getCoordinateEnd();
        }

        return ArraysOperation.mergeArrays(forceCoordinates,
                ArraysOperation.mergeArrays(momentCoordinates,
                        ArraysOperation.mergeArrays(distributedRectangleCoordinates, distributedTriangleCoordinates
                        )
                )
        );
    }

    private static Double[] getBeamCoordinates(Subcase subcase) {
        Double[] coordinates = new Double[2];
        coordinates[0] = 0.0;
        coordinates[1] = subcase.getBeam().getLength();

        Arrays.sort(coordinates);

        return coordinates;
    }

    private static Double[] getDisplacementCoordinates(Subcase subcase) {
        int displacementCount = subcase.getDisplacementList().getCountDisplacements();
        Double[] coordinates = new Double[displacementCount];

        if (displacementCount == 1)
            coordinates[0] = subcase.getDisplacementList()
                    .getFullDisplacement()
                    .get(0)
                    .getCoordinate();
        else {
            coordinates[0] = subcase.getDisplacementList()
                    .getStandardDisplacement()
                    .get(0)
                    .getCoordinate();

            coordinates[1] = subcase.getDisplacementList()
                    .getStandardDisplacement()
                    .get(1)
                    .getCoordinate();
        }

        Arrays.sort(coordinates);

        return coordinates;
    }


    private static Double[] getStaticCoordinates(Subcase subcase) {

        Double[] loadCoordinates = getLoadCoordinates(subcase);
        Double[] beamCoordinates = getBeamCoordinates(subcase);
        Double[] displacementCoordinates = getDisplacementCoordinates(subcase);

        return ArraysOperation.mergeArrays(loadCoordinates,
                ArraysOperation.mergeArrays(beamCoordinates, displacementCoordinates)
        );
    }

    private static List<List<Double>> getSectionCoordinates(Subcase subcase) {

        List<List<Double>> sectionCoordinates = new ArrayList<>();
        List<Section> customSections = subcase.getSectionList();

        Double[] customCoordinates = new Double[customSections.size()];
        Double[] staticCoordinates = getStaticCoordinates(subcase);

        for (int i = 0; i < customSections.size(); i++)
            customCoordinates[i] = customSections.get(i).getCoordinate();

        for (int i = 0; i < staticCoordinates.length; i++)
            sectionCoordinates.add(new ArrayList<>());

        int cursor = 0;

        for (int i = 1; i < staticCoordinates.length; i++) {
            if (i >= 2)
                sectionCoordinates.get(i - 1).add(staticCoordinates[i - 1]);
            for (; cursor < customCoordinates.length; cursor++) {

                if (customCoordinates[cursor] <= staticCoordinates[i])
                    sectionCoordinates.get(i - 1).add(customCoordinates[cursor]);
                else
                    break;
            }

            if (i == staticCoordinates.length - 1)
                sectionCoordinates.get(i - 1).add(staticCoordinates[i]);
        }

        return sectionCoordinates;

    }
}
