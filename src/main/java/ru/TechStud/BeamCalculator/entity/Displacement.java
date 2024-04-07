package ru.TechStud.BeamCalculator.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "DISPLACEMENT")
@Data
@NoArgsConstructor
public class Displacement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double coordinate;

    @Column(nullable = false)
    private String type;

}
