package kea.athleticsbackend.project.service;

import kea.athleticsbackend.project.dto.ResultRequestDTO;
import kea.athleticsbackend.project.dto.ResultResponseDTO;
import kea.athleticsbackend.project.repository.DisciplineRepository;
import kea.athleticsbackend.project.repository.ParticipantRepository;
import kea.athleticsbackend.project.repository.ResultRepository;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
public class ResultService {

    private final ResultRepository resultRepository;
    private final DisciplineRepository disciplineRepository;
    private final ParticipantRepository participantRepository;

    public ResultService(ResultRepository resultRepository, DisciplineRepository disciplineRepository, ParticipantRepository participantRepository) {
        this.resultRepository = resultRepository;
        this.disciplineRepository = disciplineRepository;
        this.participantRepository = participantRepository;
    }


    public List<ResultResponseDTO> getAll() {
        return resultRepository.findAll().stream()
                .map(result -> new ResultResponseDTO(result.getDiscipline().getName(), result.getParticipant().getName(), result.getResultValue()))
                .collect(java.util.stream.Collectors.toList());
    }

    public ResultResponseDTO getById(Long id) {
        return resultRepository.findById(id)
                .map(result -> new ResultResponseDTO(result.getDiscipline().getName(), result.getParticipant().getName(), result.getResultValue()))
                .orElseThrow(() -> new IllegalArgumentException("Result with id " + id + " not found"));
    }

    public void saveResult(ResultRequestDTO resultRequestDTO) {
        resultRepository.save(resultRequestDTO.toResult(disciplineRepository, participantRepository));
    }

}
