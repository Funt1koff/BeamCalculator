package ru.TechStud.BeamCalculator.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "SUBCASE")
public class Subcase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "beam_id")
    private Beam beam;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Force> forces;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Moment> moments;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DistributedRectangle> distributedRectangles;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Displacement> displacements;
}
