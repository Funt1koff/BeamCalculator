package ru.TechStud.BeamCalculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.TechStud.BeamCalculator.entity.DistributedRectangle;

@Repository
public interface DistributedRectangleRepository extends JpaRepository<DistributedRectangle, Long> {
}
