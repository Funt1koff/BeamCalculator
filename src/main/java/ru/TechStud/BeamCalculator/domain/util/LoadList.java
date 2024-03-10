package ru.TechStud.BeamCalculator.domain.util;

import org.springframework.beans.factory.annotation.Autowired;
import ru.TechStud.BeamCalculator.domain.load.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static ru.TechStud.BeamCalculator.domain.load.Load.*;

public class LoadList {

    private final HashMap<Integer, ArrayList<Load>> loadContainer = new HashMap<>();

    @Autowired
    public LoadList() {
        loadContainer.put(FORCE, new ArrayList<>());
        loadContainer.put(MOMENT, new ArrayList<>());
        loadContainer.put(DISTRIBUTED_RECTANGLE, new ArrayList<>());
        loadContainer.put(DISTRIBUTED_TRIANGLE, new ArrayList<>());
    }

    public void addLoad(Load load) {
        Integer loadType = filterByType(load);
        loadContainer.get(loadType).add(load);
    }

    public List<Force> getForces() {
        List<Force> forceList = new ArrayList<>();

        for (Load load : loadContainer.get(FORCE))
            forceList.add((Force) load);

        return forceList;
    }

    public List<Moment> getMoments() {
        List<Moment> forceList = new ArrayList<>();

        for (Load load : loadContainer.get(FORCE))
            forceList.add((Moment) load);

        return forceList;
    }

    public List<DistributedRectangle> getDistributedsRectangle() {
        List<DistributedRectangle> forceList = new ArrayList<>();

        for (Load load : loadContainer.get(FORCE))
            forceList.add((DistributedRectangle) load);

        return forceList;
    }

    public List<DistributedTriangle> getDistributedsTriangle() {
        List<DistributedTriangle> forceList = new ArrayList<>();

        for (Load load : loadContainer.get(FORCE))
            forceList.add((DistributedTriangle) load);

        return forceList;
    }



    private Integer filterByType(Load load) {

        if (load instanceof Force)
            return ((Force) load).getIDENTIFIER();

        else if (load instanceof Moment)
            return ((Moment) load).getIDENTIFIER();

        else if (load instanceof DistributedRectangle)
            return ((DistributedRectangle) load).getIDENTIFIER();

        else if (load instanceof DistributedTriangle)
            return ((DistributedTriangle) load).getIDENTIFIER();

        else return null;

    }
}
