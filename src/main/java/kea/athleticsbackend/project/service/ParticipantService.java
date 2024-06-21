package kea.athleticsbackend.project.service;

import kea.athleticsbackend.project.dto.ParticipantRequestDTO;
import kea.athleticsbackend.project.dto.ParticipantResponseDTO;
import kea.athleticsbackend.project.model.Discipline;
import kea.athleticsbackend.project.repository.ParticipantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantService {

    private final ParticipantRepository participantRepository;

    public ParticipantService(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    public List<ParticipantResponseDTO> getAll() {
        try {
            if (participantRepository.findAll().isEmpty()) {
                throw new IllegalArgumentException("No participants found");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return participantRepository.findAll().stream()
                .map(participant -> new ParticipantResponseDTO(participant.getId(), participant.getName(), participant.getAge(), participant.getClub(), participant.getDisciplines().stream().map(Discipline::getName).toList()))
                .collect(java.util.stream.Collectors.toList());
    }

    public ParticipantResponseDTO getById(Long id) {
        try {
            return participantRepository.findById(id)
                    .map(participant -> new ParticipantResponseDTO(participant.getId(), participant.getName(), participant.getAge(), participant.getClub(), participant.getDisciplines().stream().map(Discipline::getName).toList()))
                    .orElseThrow(() -> new IllegalArgumentException("Participant with id " + id + " not found"));

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public ParticipantResponseDTO saveParticipant(ParticipantRequestDTO participantRequestDTO) {
        return new ParticipantResponseDTO(participantRepository.save(participantRequestDTO.toParticipant()));
    }


    public ParticipantResponseDTO updateParticipant(Long id, ParticipantRequestDTO participantRequestDTO) {
        return participantRepository.findById(id)
                //IDK why it uses a .map here, but if it works it works
                .map(participant -> {
                    participant.setName(participantRequestDTO.getName());
                    participant.setAge(participantRequestDTO.getAge());
                    participant.setClub(participantRequestDTO.getClub());
                    return new ParticipantResponseDTO(participantRepository.save(participant));
                })
                .orElseThrow(() -> new IllegalArgumentException("Participant with id " + id + " not found"));
    }

    public void deleteParticipant(Long id) {
        participantRepository.deleteById(id);
    }
}
