package kea.athleticsbackend.project.repository;
import kea.athleticsbackend.project.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result, Long> {
}
