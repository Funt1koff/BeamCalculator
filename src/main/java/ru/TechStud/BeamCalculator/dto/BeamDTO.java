package ru.TechStud.BeamCalculator.dto;

import lombok.Data;

@Data
public class BeamDTO {

    private Double length;
    private Double area;
    private Double inertiaX;
    private Double inertiaY;

}
