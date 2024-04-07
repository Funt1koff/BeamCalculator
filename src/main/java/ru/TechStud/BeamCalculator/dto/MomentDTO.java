package ru.TechStud.BeamCalculator.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MomentDTO {

    @Min(0)
    @Max(100)
    private Double coordinate;
    private Double value;

}
