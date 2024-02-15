package ru.TechStud.BeamCalculator.domain.sample;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.TechStud.BeamCalculator.domain.load.Load;

import java.util.List;

@Data
@NoArgsConstructor
public class SetLoad {
    private List<Load> loads;
    @Getter
    private int numberLoads = loads.size();
}
