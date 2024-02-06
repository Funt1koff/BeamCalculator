package ru.TechStud.BeamCalculator.Core.Beam;

import org.springframework.stereotype.Component;


@Component
public class BeamFactory {
    private static final String RECTANGLE = "RECTANGLE";
    private static final String CIRCLE = "CIRCLE";
    private static final String FREE = "FREE";

    public static Beam getBeam(String Type) {
        if(RECTANGLE.equalsIgnoreCase(Type))
            return new RectangleBeam();
        else if(CIRCLE.equalsIgnoreCase(Type))
            return new CircleBeam();
        else if(FREE.equalsIgnoreCase(Type))
            return new Beam();
        else return null;
    }
}
