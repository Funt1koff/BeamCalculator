package ru.TechStud.BeamCalculator.domain.utilites.selector;

import ru.TechStud.BeamCalculator.domain.displacement.Displacement;
import ru.TechStud.BeamCalculator.domain.displacement.FullDisplacement;
import ru.TechStud.BeamCalculator.domain.displacement.StandardDisplacement;
import ru.TechStud.BeamCalculator.domain.load.Load;
import ru.TechStud.BeamCalculator.domain.load.distributed.DistributedRectangle;
import ru.TechStud.BeamCalculator.domain.load.distributed.DistributedTriangle;
import ru.TechStud.BeamCalculator.domain.load.force.ForceConcentrated;
import ru.TechStud.BeamCalculator.domain.load.moment.MomentConcentrated;
import ru.TechStud.BeamCalculator.domain.sample.Sample;

import java.util.ArrayList;
import java.util.List;

public class Selector {

    public static List<FullDisplacement> selectFullDisplacement(List<Displacement> displacements)   {
        List<FullDisplacement> fullDisplacements = new ArrayList<>();

        for(Displacement displacement : displacements)
            if(displacement instanceof FullDisplacement)
                fullDisplacements.add((FullDisplacement) displacement);

        return fullDisplacements;
    }

    public static List<StandardDisplacement> setStandardDisplacement(List<Displacement> displacements)  {
        List<StandardDisplacement> standardDisplacements = new ArrayList<>();

        for(Displacement displacement : displacements)
            if(displacement instanceof StandardDisplacement)
                standardDisplacements.add((StandardDisplacement) displacement);

        return standardDisplacements;
    }

    public static List<ForceConcentrated> setForceConcentrated(List<Load> loads)    {
        List<ForceConcentrated> forcesConcentrated = new ArrayList<>();

        for(Load load : loads)
            if(load instanceof ForceConcentrated)
                forcesConcentrated.add((ForceConcentrated) load);

        return forcesConcentrated;
    }

    public static List<MomentConcentrated> setMomentConcentrated(List<Load> loads)  {
        List<MomentConcentrated> momentsConcentrated = new ArrayList<>();

        for(Load load: loads)
            if(load instanceof MomentConcentrated)
                momentsConcentrated.add((MomentConcentrated) load);

        return momentsConcentrated;
    }

    public static List<DistributedRectangle> setDistributedRectangle(List<Load> loads)  {
        List<DistributedRectangle> distributedRectangles = new ArrayList<>();

        for(Load load: loads)
            if(load instanceof DistributedRectangle)
                distributedRectangles.add((DistributedRectangle) load);

        return distributedRectangles;
    }

    public static List<DistributedTriangle> setDistributedTriangle(List<Load> loads)    {
        List<DistributedTriangle> distributedTriangles = new ArrayList<>();

        for(Load load: loads)
            if(load instanceof DistributedTriangle)
                distributedTriangles.add((DistributedTriangle) load);

        return distributedTriangles;
    }

    public static List<FullDisplacement> selectFullDisplacement(Sample currentSample) {
        List<Displacement> displacements = currentSample.getSetDisplacements().getDisplacements();
        List<FullDisplacement> fullDisplacements = new ArrayList<>();

        for (Displacement displacement : displacements)
            if (displacement instanceof FullDisplacement)
                fullDisplacements.add((FullDisplacement) displacement);

        return fullDisplacements;
    }

    public static List<StandardDisplacement> setStandardDisplacement(Sample currentSample)  {
        List<Displacement> displacements = currentSample.getSetDisplacements().getDisplacements();
        List<StandardDisplacement> standardDisplacements = new ArrayList<>();

        for(Displacement displacement : displacements)
            if(displacement instanceof StandardDisplacement)
                standardDisplacements.add((StandardDisplacement) displacement);

        return standardDisplacements;
    }

    public static List<ForceConcentrated> setForceConcentrated(Sample currentSample)    {
        List<Load> loads = currentSample.getSetLoad().getLoads();
        List<ForceConcentrated> forcesConcentrated = new ArrayList<>();

        for(Load load : loads)
            if(load instanceof ForceConcentrated)
                forcesConcentrated.add((ForceConcentrated) load);

        return forcesConcentrated;
    }

    public static List<MomentConcentrated> setMomentConcentrated(Sample currentSample)  {
        List<Load> loads = currentSample.getSetLoad().getLoads();
        List<MomentConcentrated> momentsConcentrated = new ArrayList<>();

        for(Load load: loads)
            if(load instanceof MomentConcentrated)
                momentsConcentrated.add((MomentConcentrated) load);

        return momentsConcentrated;
    }

    public static List<DistributedRectangle> setDistributedRectangle(Sample currentSample)  {
        List<Load> loads = currentSample.getSetLoad().getLoads();
        List<DistributedRectangle> distributedRectangles = new ArrayList<>();

        for(Load load: loads)
            if(load instanceof DistributedRectangle)
                distributedRectangles.add((DistributedRectangle) load);

        return distributedRectangles;
    }

    public static List<DistributedTriangle> setDistributedTriangle(Sample currentSample)    {
        List<Load> loads = currentSample.getSetLoad().getLoads();
        List<DistributedTriangle> distributedTriangles = new ArrayList<>();

        for(Load load: loads)
            if(load instanceof DistributedTriangle)
                distributedTriangles.add((DistributedTriangle) load);

        return distributedTriangles;
    }


}
