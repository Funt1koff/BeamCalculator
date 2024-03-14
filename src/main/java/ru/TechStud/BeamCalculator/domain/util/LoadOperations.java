package ru.TechStud.BeamCalculator.domain.util;

import ru.TechStud.BeamCalculator.domain.load.DistributedRectangle;
import ru.TechStud.BeamCalculator.domain.load.DistributedTriangle;
import ru.TechStud.BeamCalculator.domain.section.Section;
import ru.TechStud.BeamCalculator.domain.subcase.Subcase;

import java.util.ArrayList;
import java.util.List;

public abstract class LoadOperations {

    public static Boolean isInDistributedLoad(Section section, Subcase subcase) {

        List<DistributedRectangle> distributedRectangles = subcase.getLoadList().getDistributedsRectangle();
        List<DistributedTriangle> distributedTriangles = subcase.getLoadList().getDistributedsTriangle();

        boolean isInDistributedLoad = false;

        for (DistributedRectangle distributedRectangle : distributedRectangles)
            if (section.getCoordinate() > distributedRectangle.getCoordinateStart() &
                    section.getCoordinate() <= distributedRectangle.getCoordinateEnd()) {
                isInDistributedLoad = true;
                break;
            }

        for (DistributedTriangle distributedTriangle : distributedTriangles)
            if (section.getCoordinate() > distributedTriangle.getCoordinateStart() &
                    section.getCoordinate() <= distributedTriangle.getCoordinateEnd()) {
                isInDistributedLoad = true;
                break;
            }

        return isInDistributedLoad;
    }

    public static List<DistributedRectangle> rectangleInWitchSection(Section section, Subcase subcase) {

        List<DistributedRectangle> distributedRectangles = subcase.getLoadList().getDistributedsRectangle();
        List<DistributedRectangle> resultList = new ArrayList<>();

        for (DistributedRectangle distributedRectangle : distributedRectangles)
            if (section.getCoordinate() > distributedRectangle.getCoordinateStart() &
                    section.getCoordinate() <= distributedRectangle.getCoordinateEnd())
                resultList.add(distributedRectangle);

        return resultList;
    }

    public static List<DistributedTriangle> triangleInWitchSection(Section section, Subcase subcase) {

        List<DistributedTriangle> distributedTriangles = subcase.getLoadList().getDistributedsTriangle();
        List<DistributedTriangle> resultList = new ArrayList<>();

        for (DistributedTriangle distributedTriangle : distributedTriangles)
            if (section.getCoordinate() > distributedTriangle.getCoordinateStart() &
                    section.getCoordinate() <= distributedTriangle.getCoordinateEnd())
                resultList.add(distributedTriangle);

        return resultList;
    }
}
