package ru.TechStud.BeamCalculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.TechStud.BeamCalculator.entity.Load;

@Repository
public interface LoadRepository extends JpaRepository<Load, Long> {
}
