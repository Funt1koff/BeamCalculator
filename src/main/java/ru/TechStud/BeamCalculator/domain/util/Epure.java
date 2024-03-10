package ru.TechStud.BeamCalculator.domain.util;

import ru.TechStud.BeamCalculator.domain.result.Result;

import java.util.List;
import java.util.Objects;

public abstract class Epure {

    public static List<Result> sumSitesForce(List<Result> unsummedEpure) {
        for (int i = 0; i < unsummedEpure.size(); i++) {

            if (i > 0) {
                if (Objects.equals(unsummedEpure.get(i).getCoordinate(), unsummedEpure.get(i - 1).getCoordinate()))
                    unsummedEpure.get(i).setValueForceCross(
                            unsummedEpure.get(i).getValueForceCross() + unsummedEpure.get(i - 1).getValueForceCross()
                    );
                else unsummedEpure.get(i).setValueForceCross(
                        unsummedEpure.get(i - 1).getValueForceCross()
                );
            }
        }
        return unsummedEpure;
    }

    //Add function to aproximate!
}
