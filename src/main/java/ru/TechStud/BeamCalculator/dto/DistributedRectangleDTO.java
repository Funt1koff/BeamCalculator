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
public class DistributedRectangleDTO {

    @Min(0)
    @Max(100)
    private Double coordinateStart;
    private Double coordinateEnd;
    private Double valuePerLength;

}
