package ru.TechStud.BeamCalculator.domain.calculator.basecase;

import ru.TechStud.BeamCalculator.domain.calculator.BaseCase;
import ru.TechStud.BeamCalculator.domain.load.Force;
import ru.TechStud.BeamCalculator.domain.result.Result;

import java.util.ArrayList;
import java.util.List;

public abstract class ForceStandardDisplacement implements BaseCase {

    public static List<Result> getResult(Double value, Double coordinate, Double coordinateEndSite) {

        List<Result> resultList = new ArrayList<>();
        Double lengthSite = (coordinateEndSite - coordinate) / quantitySites;

        for (int i = 0; i <= quantitySites; i++)
            resultList.add(new Result(
                    i * lengthSite + coordinate,
                    value,
                    value * i * lengthSite // The moments are not working properly!
            ));

        return resultList;
    }

    public static List<Result> getResult(Force force, Double coordinateEndSite) {

        List<Result> resultList = new ArrayList<>();
        Double value = force.getValue();
        Double coordinate = force.getCoordinate();
        Double lengthSite = (coordinateEndSite - coordinate) / quantitySites;

        for (int i = 0; i <= quantitySites; i++)
            resultList.add(new Result(
                    i * lengthSite + coordinate,
                    value,
                    value * i * lengthSite // The moments are not working properly!
            ));

        return resultList;
    }
}
