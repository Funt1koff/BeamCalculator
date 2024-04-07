package ru.TechStud.BeamCalculator.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubcaseDTO {

    private BeamDTO beam;

    @Size(max = 4)
    private List<ForceDTO> forces;

    @Size(max = 4)
    private List<MomentDTO> moments;

    @Size(max = 2)
    private List<DistributedRectangleDTO> distributedRectangles;

    @Size(max = 2)
    private List<DisplacementDTO> displacements;
}
