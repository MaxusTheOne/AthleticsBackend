package kea.athleticsbackend.project.repository;

import kea.athleticsbackend.project.model.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
}
