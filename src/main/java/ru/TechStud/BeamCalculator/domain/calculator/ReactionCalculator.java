package ru.TechStud.BeamCalculator.domain.calculator;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.TechStud.BeamCalculator.domain.displacement.FullDisplacement;
import ru.TechStud.BeamCalculator.domain.displacement.StandardDisplacement;
import ru.TechStud.BeamCalculator.domain.sample.Sample;
import ru.TechStud.BeamCalculator.domain.utilites.selector.Selector;

import java.util.HashMap;
import java.util.List;
@RequiredArgsConstructor
@Getter
public class ReactionCalculator {

    private Sample currentSample;

    private final List<StandardDisplacement> standardDisplacements = Selector.setStandardDisplacement(currentSample);
    private final List<FullDisplacement> fullDisplacements = Selector.selectFullDisplacement(currentSample);

    public HashMap<Double, Double> getValues()  {

        HashMap<Double, Double> result = new HashMap<>();

        if(fullDisplacements.isEmpty()) {
            double[] reactions = calculateStandardReactions();

            for(int i = 0; i < reactions.length; i++)
                result.put(standardDisplacements.get(i).getCoordinate(), reactions[i]);
        }
        else {
            result.put(
                    fullDisplacements.get(0).getCoordinate(),
                    calculateFullReaction()
            );
        }
        return result;
    }

    public double[] calculateStandardReactions()    {
        double value1 = 0, value2 = 0;

        //Next try...

        return new double[] {value1, value2};
    }

    public double calculateFullReaction()    {

        double value = 0;

        return value;
    }
}
