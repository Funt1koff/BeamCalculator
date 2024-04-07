package ru.TechStud.BeamCalculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.TechStud.BeamCalculator.entity.Displacement;

@Repository
public interface DisplacementRepository extends JpaRepository<Displacement, Long> {
}
