package ru.TechStud.BeamCalculator.domain.util;

import org.springframework.beans.factory.annotation.Autowired;
import ru.TechStud.BeamCalculator.domain.displacement.Displacement;
import ru.TechStud.BeamCalculator.domain.displacement.FullDisplacement;
import ru.TechStud.BeamCalculator.domain.displacement.StandardDisplacement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static ru.TechStud.BeamCalculator.domain.displacement.Displacement.FULL;
import static ru.TechStud.BeamCalculator.domain.displacement.Displacement.STANDARD;

public class DisplacementList {

    private final HashMap<Integer, ArrayList<Displacement>> displacementContainer = new HashMap<>();

    @Autowired
    public DisplacementList() {
        displacementContainer.put(STANDARD, new ArrayList<>());
        displacementContainer.put(FULL, new ArrayList<>());
    }

    public void addDisplacement(Displacement displacement) {
        Integer displacementType = filterByType(displacement);

        boolean isFreely = (
                (Objects.equals(displacementType, STANDARD) & displacementContainer.get(STANDARD).size() < 2) ||
                        (Objects.equals(displacementType, FULL) & displacementContainer.get(FULL).isEmpty())
        );
        if (isFreely)
            displacementContainer.get(displacementType).add(displacement);
    }

    public List<StandardDisplacement> getStandardDisplacement() {
        List<StandardDisplacement> standardDisplacements = new ArrayList<>();

        for (Displacement displacement : displacementContainer.get(STANDARD))
            standardDisplacements.add((StandardDisplacement) displacement);

        return standardDisplacements;
    }

    public List<FullDisplacement> getFullDisplacement() {
        List<FullDisplacement> fullDisplacements = new ArrayList<>();

        for (Displacement displacement : displacementContainer.get(FULL))
            fullDisplacements.add((FullDisplacement) displacement);

        return fullDisplacements;
    }

    public Integer getCountDisplacements() {
        if (displacementContainer.get(STANDARD).isEmpty())
            return displacementContainer.get(FULL).size();
        else
            return displacementContainer.get(STANDARD).size();
    }

    private Integer filterByType(Displacement displacement) {

        if (displacement instanceof StandardDisplacement)
            return ((StandardDisplacement) displacement).getIDENTIFIER();
        else
            return ((FullDisplacement) displacement).getIDENTIFIER();

    }
}
