package ru.TechStud.BeamCalculator.domain.util;

import org.springframework.beans.factory.annotation.Autowired;
import ru.TechStud.BeamCalculator.domain.load.*;
import ru.TechStud.BeamCalculator.domain.section.Section;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

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

        for (Load load : loadContainer.get(MOMENT))
            forceList.add((Moment) load);

        return forceList;
    }

    public List<DistributedRectangle> getDistributedsRectangle() {
        List<DistributedRectangle> forceList = new ArrayList<>();

        for (Load load : loadContainer.get(DISTRIBUTED_RECTANGLE))
            forceList.add((DistributedRectangle) load);

        return forceList;
    }

    public List<DistributedTriangle> getDistributedsTriangle() {
        List<DistributedTriangle> forceList = new ArrayList<>();

        for (Load load : loadContainer.get(DISTRIBUTED_TRIANGLE))
            forceList.add((DistributedTriangle) load);

        return forceList;
    }

    public List<Section> getLoadSections() {

        List<Section> loadSections = new ArrayList<>();

        List<Force> forceList = getForces();
        List<Moment> momentList = getMoments();
        List<DistributedRectangle> distributedRectangles = getDistributedsRectangle();
        List<DistributedTriangle> distributedTriangles = getDistributedsTriangle();

        for (Force force : forceList) {
            loadSections.add(new Section(force.getCoordinate(), true));
            loadSections.add(new Section(force.getCoordinate(), true));
        }

        for (Moment moment : momentList) {
            loadSections.add(new Section(moment.getCoordinate(), true));
            loadSections.add(new Section(moment.getCoordinate(), true));
        }

        for (DistributedRectangle distributedRectangle : distributedRectangles) {
            loadSections.add(new Section(distributedRectangle.getCoordinateStart(), true));
            loadSections.add(new Section(distributedRectangle.getCoordinateStart(), true));
            loadSections.add(new Section(distributedRectangle.getCoordinateEnd(), true));
            loadSections.add(new Section(distributedRectangle.getCoordinateEnd(), true));
        }

        for (DistributedTriangle distributedTriangle : distributedTriangles) {
            loadSections.add(new Section(distributedTriangle.getCoordinateStart(), true));
            loadSections.add(new Section(distributedTriangle.getCoordinateStart(), true));
            loadSections.add(new Section(distributedTriangle.getCoordinateEnd(), true));
            loadSections.add(new Section(distributedTriangle.getCoordinateEnd(), true));
        }

        loadSections.sort(
                (coordinate1, coordinate2) -> {
                    if (coordinate1.getCoordinate() > coordinate2.getCoordinate())
                        return 1;
                    else if (coordinate1.getCoordinate() < coordinate2.getCoordinate())
                        return -1;
                    else
                        return 0;
                }
        );

        return loadSections;
    }

    public List<Force> findForceByCoordinate(Double coordinate) {

        List<Force> forces = new ArrayList<>();

        for (Force force : getForces())
            if (Objects.equals(force.getCoordinate(), coordinate))
                forces.add(force);

        return forces;
    }

    public List<DistributedRectangle> findDistributedRectangleByEndCoordinate(Double coordinate) {

        List<DistributedRectangle> distributedRectangles = new ArrayList<>();

        for (DistributedRectangle distributedRectangle : getDistributedsRectangle())
            if (Objects.equals(distributedRectangle.getCoordinateEnd(), coordinate))
                distributedRectangles.add(distributedRectangle);

        return distributedRectangles;
    }

    public List<DistributedTriangle> findDistributedTriangleByEndCoordinate(Double coordinate) {

        List<DistributedTriangle> distributedTriangles = new ArrayList<>();

        for (DistributedTriangle distributedTriangle : getDistributedsTriangle())
            if (Objects.equals(distributedTriangle.getCoordinateEnd(), coordinate))
                distributedTriangles.add(distributedTriangle);

        return distributedTriangles;

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
