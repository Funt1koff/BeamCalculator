package ru.TechStud.BeamCalculator.Core.Force;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@RequiredArgsConstructor
public class Force {

    private long forceId;
    private double value;
    private double coordinate; //координата приложения силы


}
