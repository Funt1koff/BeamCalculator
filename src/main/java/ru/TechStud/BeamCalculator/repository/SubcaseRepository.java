package ru.TechStud.BeamCalculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.TechStud.BeamCalculator.entity.Subcase;

@Repository
public interface SubcaseRepository extends JpaRepository<Subcase, Long> {
}
