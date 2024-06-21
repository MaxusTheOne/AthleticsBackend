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



    //This right here made me realize I made some spaghetti
    public List<ResultResponseDTO> getAll() {
        return resultRepository.findAll().stream()
                .map(result -> new ResultResponseDTO((long) result.getId(),result.getDiscipline().getResultType(), result.getParticipant().getName(), result.getResultValue()))
                .collect(java.util.stream.Collectors.toList());
    }

    public ResultResponseDTO getById(Long id) {
        return resultRepository.findById(id)
                .map(result -> new ResultResponseDTO(id,result.getDiscipline().getResultType(), result.getParticipant().getName(), result.getResultValue()))
                .orElseThrow(() -> new IllegalArgumentException("Result with id " + id + " not found"));
    }

    public void saveResult(ResultRequestDTO resultRequestDTO) {
        resultRepository.save(resultRequestDTO.toResult(disciplineRepository, participantRepository));
    }

    public void saveMultipleResults(List<ResultRequestDTO> resultRequestDTOs) {
        for (ResultRequestDTO resultRequestDTO : resultRequestDTOs) {
            resultRepository.save(resultRequestDTO.toResult(disciplineRepository, participantRepository));
        }
    }

    public void updateResult(Long id, ResultRequestDTO resultRequestDTO) {
        resultRepository.findById(id)
                .map(result -> {
                    result.setDiscipline(disciplineRepository.findById(resultRequestDTO.getDisciplineId()).orElseThrow(() -> new IllegalArgumentException("Discipline with id " + resultRequestDTO.getDisciplineId() + " not found")));
                    result.setParticipant(participantRepository.findById(resultRequestDTO.getParticipantId()).orElseThrow(() -> new IllegalArgumentException("Participant with id " + resultRequestDTO.getParticipantId() + " not found")));
                    result.setResultValue(resultRequestDTO.getResultValue());
                    return resultRepository.save(result);
                })
                .orElseThrow(() -> new IllegalArgumentException("Result with id " + id + " not found"));
    }

    public void deleteResult(Long id) {
        resultRepository.deleteById(id);
    }
}
