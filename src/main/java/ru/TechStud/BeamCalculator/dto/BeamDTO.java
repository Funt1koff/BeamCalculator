package ru.TechStud.BeamCalculator.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BeamDTO {

    @Min(1)
    @Max(100)
    private Double length;
    @Min(1)
    private Double area;
    @Min(1)
    private Double inertia;

}
