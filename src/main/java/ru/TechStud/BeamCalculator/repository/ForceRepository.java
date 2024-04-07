package ru.TechStud.BeamCalculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.TechStud.BeamCalculator.entity.Force;

@Repository
public interface ForceRepository extends JpaRepository<Force, Long> {
}
