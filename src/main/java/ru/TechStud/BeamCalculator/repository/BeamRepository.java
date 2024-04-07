package ru.TechStud.BeamCalculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.TechStud.BeamCalculator.entity.Beam;

@Repository
public interface BeamRepository extends JpaRepository<Beam, Long> {

}
