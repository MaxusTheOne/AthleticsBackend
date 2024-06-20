package kea.athleticsbackend.project.repository;


import kea.athleticsbackend.project.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Long>{
}
