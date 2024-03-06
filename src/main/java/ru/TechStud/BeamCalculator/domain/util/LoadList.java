package ru.TechStud.BeamCalculator.domain.util;

import ru.TechStud.BeamCalculator.domain.load.Force;
import ru.TechStud.BeamCalculator.entity.Load;

import java.util.ArrayList;
import java.util.HashMap;

import static ru.TechStud.BeamCalculator.domain.load.Load.*;

public class LoadList {

    private final HashMap<Integer, ArrayList<Load>> loadContainer = new HashMap<>();

    public LoadList()   {
        loadContainer.put(FORCE, new ArrayList<>());
        loadContainer.put(MOMENT, new ArrayList<>());
        loadContainer.put(DISTRIBUTED_RECTANGLE, new ArrayList<>());
        loadContainer.put(DISTRIBUTED_TRIANGLE, new ArrayList<>());
    }

    public void addLoad(Load load)  {

    }

//    private Integer filterByType(Load load) {
//
//    }
}
