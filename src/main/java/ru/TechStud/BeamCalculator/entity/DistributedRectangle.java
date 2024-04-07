package ru.TechStud.BeamCalculator.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "DISTRIBUTED_RECTANGLE")
public class DistributedRectangle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double coordinateStart;

    @Column(nullable = false)
    private Double coordinateEnd;

    @Column(nullable = false)
    private Double valuePerLength;
}
