package ru.TechStud.BeamCalculator.domain.calculator;

import lombok.RequiredArgsConstructor;
import ru.TechStud.BeamCalculator.domain.calculator.basecase.ForceStandardDisplacement;
import ru.TechStud.BeamCalculator.domain.load.Force;
import ru.TechStud.BeamCalculator.domain.result.Result;
import ru.TechStud.BeamCalculator.domain.subcase.Subcase;
import ru.TechStud.BeamCalculator.domain.util.Epure;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@RequiredArgsConstructor
public class Calculator {

    private Subcase subcase;
    private List<Result> resultList = new ArrayList<>();

    public List<Result> getResults()    {
        calculate();
        return resultList;
    }

    //For future distributed Load Facade
    private void calculate()    {
        calculateCrossForce();
    }

    private void calculateCrossForce()  {

        ReactionCalculator reactionCalculator = new ReactionCalculator(subcase);

        List<Force> forces = subcase.getLoadList().getForces();

        forces.addAll(reactionCalculator.getReactionsLikeForces());

        forces.sort((v1, v2) ->  {
            return v2.getCoordinate().compareTo(v1.getCoordinate());
        });

        List<Result> forceResult = new ArrayList<>();

        for(int i = 0; i < forces.size(); i++)
            forceResult.addAll(ForceStandardDisplacement.getResult(forces.get(i), forces.get(i + 1).getCoordinate()));

        forceResult = Epure.sumSitesForce(forceResult);

        resultList = forceResult;
    }
}
