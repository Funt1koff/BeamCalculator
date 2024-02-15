package ru.TechStud.BeamCalculator.domain.utilites.converter;

import lombok.Getter;

import java.util.Arrays;

public class LengthConverter {
    @Getter
    private static final double MAX_RELATIVE_LENGTH = 1;
    @Getter
    private static final double MIN_RELATIVE_LENGTH = 0;


    public static double[] ConvertToRelative(double[] sections) {

        Arrays.sort(sections);

        double valueMax = sections[sections.length - 1];

        for(int i = 0; i < sections.length; i++)
            sections[i] = sections[i]/valueMax;

        return sections;
    }
}
