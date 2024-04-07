package ru.TechStud.BeamCalculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.TechStud.BeamCalculator.entity.Moment;

@Repository
public interface MomentRepository extends JpaRepository<Moment, Long> {

}
