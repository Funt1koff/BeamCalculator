package ru.TechStud.BeamCalculator.domain.calculator;

import ru.TechStud.BeamCalculator.domain.displacement.FullDisplacement;
import ru.TechStud.BeamCalculator.domain.displacement.StandardDisplacement;
import ru.TechStud.BeamCalculator.domain.load.DistributedRectangle;
import ru.TechStud.BeamCalculator.domain.load.DistributedTriangle;
import ru.TechStud.BeamCalculator.domain.load.Force;
import ru.TechStud.BeamCalculator.domain.load.Moment;
import ru.TechStud.BeamCalculator.domain.result.Reaction;
import ru.TechStud.BeamCalculator.domain.subcase.Subcase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReactionCalculator {

    private final Subcase subcase;
    private final List<Reaction> reactions = new ArrayList<>();

    public ReactionCalculator(Subcase subcase) {
        this.subcase = subcase;
    }

    public List<Reaction> getReactions() {
        calculate();
        return reactions;
    }

    public List<Force> getReactionsLikeForces() {
        calculate();
        List<Force> reactionForces = new ArrayList<>();

        for (Reaction reaction : reactions)
            reactionForces.add(new Force(reaction.getCoordinate(), reaction.getValue()));

        return reactionForces;
    }

    private void calculate() {
        List<Force> forceList = subcase.getLoadList().getForces();

        List<Moment> momentList = subcase.getLoadList().getMoments();

        List<DistributedRectangle> distributedRectangles = subcase.getLoadList().getDistributedsRectangle();

        List<DistributedTriangle> distributedTriangles = subcase.getLoadList().getDistributedsTriangle();

        List<StandardDisplacement> standardDisplacementList = subcase.getDisplacementList().getStandardDisplacement();

        List<FullDisplacement> fullDisplacements = subcase.getDisplacementList().getFullDisplacement();

        int countDisplacement;

        if (standardDisplacementList.isEmpty())
            countDisplacement = fullDisplacements.size();
        else
            countDisplacement = standardDisplacementList.size();

        Double[] coordinateDisplacement = new Double[countDisplacement];
        Double[] values = new Double[countDisplacement];

        Arrays.fill(values, 0.0);

        if (fullDisplacements.isEmpty()) {

            for (int i = 0; i < countDisplacement; i++)
                coordinateDisplacement[i] = standardDisplacementList.get(i).getCoordinate();

            for (int i = 0; i < countDisplacement; i++)
                for (Force force : forceList)
                    values[i] += force.getValue() * (coordinateDisplacement[i] = force.getCoordinate());

            for(int i = 0; i < countDisplacement; i++)
                for(Moment moment : momentList)
                    values[i] += moment.getValue();

            for(int i = 0; i < countDisplacement; i++)
                for(DistributedRectangle distributedRectangle : distributedRectangles)
                    values[i] += distributedRectangle.getValueEquivalent() *
                            (coordinateDisplacement[i] - distributedRectangle.getCoordinateCenterMass());

            for(int i = 0; i < countDisplacement; i++)
                for(DistributedTriangle distributedTriangle : distributedTriangles)
                    values[i] += distributedTriangle.getValueEquivalent() *
                            (coordinateDisplacement[i] - distributedTriangle.getCoordinateCenterMass());

            values[0] = -values[0] / (coordinateDisplacement[0] - coordinateDisplacement[1]);
            values[1] = -values[1] / (coordinateDisplacement[1] - coordinateDisplacement[0]);

            //Kostil
            Double temp;
            temp = values[0];
            values[0] = values[1];
            values[1] = temp;

        }
        else {
            for(Force force : forceList)
                values[0] += force.getValue();

            for(DistributedRectangle distributedRectangle : distributedRectangles)
                values[0] += distributedRectangle.getValueEquivalent();

            for(DistributedTriangle distributedTriangle : distributedTriangles)
                values[0] += distributedTriangle.getValueEquivalent();

            values[0] = -values[0];
        }

        for(int i = 0; i < countDisplacement; i++)
            reactions.add(new Reaction(coordinateDisplacement[i], values[i]));


    }
}
