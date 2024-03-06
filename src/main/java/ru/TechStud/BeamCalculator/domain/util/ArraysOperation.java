package ru.TechStud.BeamCalculator.domain.util;

import ru.TechStud.BeamCalculator.domain.section.Section;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ArraysOperation {

    public static Double[] mergeArrays(Double[] array1, Double[] array2)    {
        Double[] mergeArray = new Double[array1.length + array2.length];

        System.arraycopy(array1, 0, mergeArray, 0, array1.length);
        System.arraycopy(array2, 0, mergeArray, array1.length, array2.length);
        Arrays.sort(mergeArray);

        return mergeArray;
    }

    public static Integer[] mergeArrays(Integer[] array1, Integer[] array2)    {
        Integer[] mergeArray = new Integer[array1.length + array2.length];

        System.arraycopy(array1, 0, mergeArray, 0, array1.length);
        System.arraycopy(array2, 0, mergeArray, array1.length, array2.length);
        Arrays.sort(mergeArray);

        return mergeArray;
    }

    public static Byte[] mergeArrays(Byte[] array1, Byte[] array2)    {
        Byte[] mergeArray = new Byte[array1.length + array2.length];

        System.arraycopy(array1, 0, mergeArray, 0, array1.length);
        System.arraycopy(array2, 0, mergeArray, array1.length, array2.length);
        Arrays.sort(mergeArray);

        return mergeArray;
    }

    public static Character[] mergeArrays(Character[] array1, Character[] array2)    {
        Character[] mergeArray = new Character[array1.length + array2.length];

        System.arraycopy(array1, 0, mergeArray, 0, array1.length);
        System.arraycopy(array2, 0, mergeArray, array1.length, array2.length);
        Arrays.sort(mergeArray);

        return mergeArray;
    }

    public static Float[] mergeArrays(Float[] array1, Float[] array2)    {
        Float[] mergeArray = new Float[array1.length + array2.length];

        System.arraycopy(array1, 0, mergeArray, 0, array1.length);
        System.arraycopy(array2, 0, mergeArray, array1.length, array2.length);
        Arrays.sort(mergeArray);

        return mergeArray;
    }

    public static Long[] mergeArrays(Long[] array1, Long[] array2)    {
        Long[] mergeArray = new Long[array1.length + array2.length];

        System.arraycopy(array1, 0, mergeArray, 0, array1.length);
        System.arraycopy(array2, 0, mergeArray, array1.length, array2.length);
        Arrays.sort(mergeArray);

        return mergeArray;
    }

    public static Double[] asArray(List<Double> list)   {
        Double[] resultArray = new Double[list.size()];

        for(int i = 0; i < list.size(); i++)
            resultArray[i] = list.get(i);

        return resultArray;
    }

    public static List<Section> mergeSectionLists (List<List<Section>> lists)    {
        List<Section> mergeSections = new ArrayList<>();

        for(List<Section> sectionList : lists)
            mergeSections.addAll(sectionList);

        return mergeSections;
    }




}
