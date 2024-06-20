package kea.athleticsbackend.project.service;

import kea.athleticsbackend.project.dto.ParticipantRequestDTO;
import kea.athleticsbackend.project.dto.ParticipantResponseDTO;
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
        return participantRepository.findAll().stream()
                .map(participant -> new ParticipantResponseDTO(participant.getId(), participant.getName(), participant.getAge(), participant.getClub()))
                .collect(java.util.stream.Collectors.toList());
    }

    public ParticipantResponseDTO getById(Long id) {
        return participantRepository.findById(id)
                .map(participant -> new ParticipantResponseDTO(participant.getId(), participant.getName(), participant.getAge(), participant.getClub()))
                .orElseThrow(() -> new IllegalArgumentException("Participant with id " + id + " not found"));
    }

    public ParticipantResponseDTO saveParticipant(ParticipantRequestDTO participantRequestDTO) {
        return new ParticipantResponseDTO(participantRepository.save(participantRequestDTO.toParticipant()));
    }


}
