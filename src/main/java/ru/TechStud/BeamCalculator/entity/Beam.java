package ru.TechStud.BeamCalculator.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "BEAM")
@Data
@NoArgsConstructor
public class Beam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double length;

    private Double area;
    private Double inertia;

}
