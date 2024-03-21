package ru.TechStud.BeamCalculator.domain.calculator;

import ru.TechStud.BeamCalculator.domain.load.DistributedRectangle;
import ru.TechStud.BeamCalculator.domain.load.DistributedTriangle;
import ru.TechStud.BeamCalculator.domain.load.Force;
import ru.TechStud.BeamCalculator.domain.result.Result;
import ru.TechStud.BeamCalculator.domain.section.Section;
import ru.TechStud.BeamCalculator.domain.subcase.Subcase;
import ru.TechStud.BeamCalculator.domain.util.LoadList;
import ru.TechStud.BeamCalculator.domain.util.LoadOperations;
import ru.TechStud.BeamCalculator.domain.util.SplitOperations;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.pow;

public class CrossForceCalculator {

    private final Subcase subcase;
    private final List<Result> resultList = new ArrayList<>();

    public CrossForceCalculator(Subcase subcase) {
        ReactionCalculator reactionCalculator = new ReactionCalculator(subcase);
        List<Force> reactions = reactionCalculator.getReactionsLikeForces();

        for (Force reaction : reactions) {
            subcase.getLoadList().addLoad(reaction);
        }

        this.subcase = subcase;
    }

    public List<Result> getResult() {
        calculate();
        return resultList;
    }

    private void calculate() {

        List<Section> sections = SplitOperations.getSections(subcase);
        LoadList currentLoadList = subcase.getLoadList();

        resultList.add(new Result(sections.get(0).getCoordinate(),
                0.0, 0.0,
                sections.get(0).getIsLoad(),
                sections.get(0).getIsDisplacement()));

        for (int i = 1; i < sections.size(); i++) {
            if (sections.get(i).getIsLoad() || sections.get(i).getIsDisplacement()) {

                List<Force> currentForces = currentLoadList
                        .findForceByCoordinate(sections.get(i).getCoordinate());
                List<DistributedRectangle> currentRectanglesEnd = currentLoadList
                        .findDistributedRectangleByEndCoordinate(sections.get(i).getCoordinate());
                List<DistributedTriangle> currentTriangleEnd = currentLoadList
                        .findDistributedTriangleByEndCoordinate(sections.get(i).getCoordinate());

                Double sumForcesInCurrentCoordinate = 0.0;
                double sumDistributedRectanglesInEndCoordinate = 0.0;
                double sumDistributedTrianglesInEndCoordinate = 0.0;

                if (!currentForces.isEmpty())
                    for (Force force : currentForces)
                        sumForcesInCurrentCoordinate += force.getValue();

                if (!currentRectanglesEnd.isEmpty())
                    for (DistributedRectangle distributedRectangle : currentRectanglesEnd)
                        sumDistributedRectanglesInEndCoordinate += distributedRectangle.getValueEquivalent() *
                                (sections.get(i).getCoordinate() - sections.get(i - 1).getCoordinate());

                if (!currentTriangleEnd.isEmpty())
                    for (DistributedTriangle distributedTriangle : currentTriangleEnd)
                        sumDistributedTrianglesInEndCoordinate += (0.5 * distributedTriangle.getValueOnUnitLength() /
                                (distributedTriangle.getCoordinateEnd() - distributedTriangle.getCoordinateStart()))
                                * (pow(sections.get(i).getCoordinate() - distributedTriangle.getCoordinateStart(), 2)
                                - pow(sections.get(i - 1).getCoordinate() - distributedTriangle.getCoordinateStart(), 2));

                Double sumLoads = sumForcesInCurrentCoordinate + sumDistributedRectanglesInEndCoordinate +
                        sumDistributedTrianglesInEndCoordinate + resultList.get(i - 1).getValueForceCross();

                resultList.add(new Result(sections.get(i).getCoordinate(), sumLoads, 0.0,
                        sections.get(i).getIsLoad(), sections.get(i).getIsDisplacement()));
            } else if (LoadOperations.isInDistributedLoad(sections.get(i), subcase)) {
                List<DistributedRectangle> currentRectangles = LoadOperations.rectangleInWitchSection(sections.get(i), subcase);
                List<DistributedTriangle> currentTriangles = LoadOperations.triangleInWitchSection(sections.get(i), subcase);

                Double sumLoads = resultList.get(i - 1).getValueForceCross();

                for(DistributedRectangle distributedRectangle : currentRectangles)
                    sumLoads += distributedRectangle.getValueOnUnitLength() *
                            (sections.get(i).getCoordinate() - sections.get(i - 1).getCoordinate());

                for(DistributedTriangle distributedTriangle : currentTriangles) {
                    sumLoads +=
                            (0.5 * distributedTriangle.getValueOnUnitLength() /
                                    (distributedTriangle.getCoordinateEnd() - distributedTriangle.getCoordinateStart()))
                            * (pow(sections.get(i).getCoordinate() - distributedTriangle.getCoordinateStart(), 2)
                            - pow(sections.get(i - 1).getCoordinate() - distributedTriangle.getCoordinateStart(), 2));
                }

                resultList.add(new Result(sections.get(i).getCoordinate(), sumLoads, 0.0,
                        sections.get(i).getIsLoad(), sections.get(i).getIsDisplacement()));

            }
            else {
                Double sumLoads = resultList.get(i - 1).getValueForceCross();
                resultList.add(new Result(sections.get(i).getCoordinate(), sumLoads, 0.0,
                        sections.get(i).getIsLoad(), sections.get(i).getIsDisplacement()));
            }
        }
    }
}
