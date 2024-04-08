package ru.TechStud.BeamCalculator.domain.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.TechStud.BeamCalculator.domain.displacement.Displacement;
import ru.TechStud.BeamCalculator.domain.load.DistributedRectangle;
import ru.TechStud.BeamCalculator.domain.load.Force;
import ru.TechStud.BeamCalculator.domain.load.Moment;
import ru.TechStud.BeamCalculator.domain.section.Section;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@DisplayName(value = "Test split operations on loads")
public class TestLoadOperations {

    @Test
    @DisplayName(value = "test split: get forces sections")
    @Tag(value = "split")
    public void forceSections() {
        List<Force> forces = Arrays.asList(
                new Force(1.0, 1.0),
                new Force(2.0, 2.0),
                new Force(3.0, 3.0),
                new Force(4.0, 4.0),
                new Force(5.0, 5.0)
        );

        List<Section> referenceList = Arrays.asList(
                new Section(1.0, true, false),
                new Section(1.0, true, false),
                new Section(2.0, true, false),
                new Section(2.0, true, false),
                new Section(3.0, true, false),
                new Section(3.0, true, false),
                new Section(4.0, true, false),
                new Section(4.0, true, false),
                new Section(5.0, true, false),
                new Section(5.0, true, false)
        );

        List<Section> resultList = LoadOperations.getLoadConcentratedSections(forces);

        Assertions.assertEquals(resultList, referenceList);
    }

    @Test
    @DisplayName(value = "test split: get moment sections")
    @Tag(value = "split")
    public void momentSections() {
        List<Moment> moments = Arrays.asList(
                new Moment(1.0, 1.0),
                new Moment(2.0, 2.0),
                new Moment(3.0, 3.0),
                new Moment(4.0, 4.0),
                new Moment(5.0, 5.0)
        );

        List<Section> referenceList = Arrays.asList(
                new Section(1.0, true, false),
                new Section(1.0, true, false),
                new Section(2.0, true, false),
                new Section(2.0, true, false),
                new Section(3.0, true, false),
                new Section(3.0, true, false),
                new Section(4.0, true, false),
                new Section(4.0, true, false),
                new Section(5.0, true, false),
                new Section(5.0, true, false)
        );

        List<Section> resultList = LoadOperations.getLoadConcentratedSections(moments);

        Assertions.assertEquals(resultList, referenceList);
    }

    @Test
    @DisplayName(value = "test split: get distributed rectangle sections")
    @Tag(value = "split")
    public void distributedSections() {
        List<DistributedRectangle> distributedRectangles = Arrays.asList(
                new DistributedRectangle(1.0, 2.0, 12.0),
                new DistributedRectangle(3.0, 4.0, 12.0),
                new DistributedRectangle(5.0, 6.0, 12.0)
        );

        List<Section> referenceList = Arrays.asList(
                new Section(1.0, true, false),
                new Section(1.0, true, false),
                new Section(2.0, true, false),
                new Section(2.0, true, false),
                new Section(3.0, true, false),
                new Section(3.0, true, false),
                new Section(4.0, true, false),
                new Section(4.0, true, false),
                new Section(5.0, true, false),
                new Section(5.0, true, false),
                new Section(6.0, true, false),
                new Section(6.0, true, false)

        );

        List<Section> resultList = LoadOperations.getLoadDistributedSections(distributedRectangles);

        Assertions.assertEquals(resultList, referenceList);
    }

    @Test
    @DisplayName(value = "test split: get standard displacement sections")
    @Tag(value = "split")
    public void standardDisplacementSections() {

        List<Displacement> displacements = Arrays.asList(
                new Displacement(2.0, "STANDARD"),
                new Displacement(8.0, "STANDARD")
        );

        List<Section> referenceList = Arrays.asList(

                new Section(2.0, false, true),
                new Section(2.0, false, true),
                new Section(8.0, false, true),
                new Section(8.0, false, true)

        );

        List<Section> resultList = LoadOperations.getDisplacementSections(displacements);

        Assertions.assertEquals(resultList, referenceList);
    }

    @Test
    @DisplayName(value = "test split: get full displacement sections")
    @Tag(value = "split")
    public void fullDisplacementSections() {

        List<Displacement> displacements = List.of(
                new Displacement(0.0, "FULL")
        );

        List<Section> referenceList = Arrays.asList(

                new Section(0.0, false, true),
                new Section(0.0, false, true)

        );

        List<Section> resultList = LoadOperations.getDisplacementSections(displacements);

        Assertions.assertEquals(resultList, referenceList);
    }
}
