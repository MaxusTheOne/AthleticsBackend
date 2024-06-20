package kea.athleticsbackend.project.dto;

import kea.athleticsbackend.project.model.Discipline;
import kea.athleticsbackend.project.model.Participant;
import kea.athleticsbackend.project.model.Result;
import kea.athleticsbackend.project.model.ResultType;
import kea.athleticsbackend.project.repository.DisciplineRepository;
import kea.athleticsbackend.project.repository.ParticipantRepository;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class ResultRequestDTO {

    private Long disciplineId;
    private Long participantId;
    private String result;
    private String date;
    private String resultValue;
    private String resultType;

    public ResultRequestDTO() {
    }

    public ResultRequestDTO(Long disciplineId, Long participantId, String result, String date, String resultValue, String resultType) {

        this.disciplineId = disciplineId;
        this.participantId = participantId;
        this.result = result;
        this.date = date;
        this.resultValue = resultValue;
        this.resultType = resultType;
    }

    public Result toResult(DisciplineRepository disciplineRepository, ParticipantRepository participantRepository) {
        Optional<Discipline> discipline = disciplineRepository.findById((long) disciplineId);
        Optional<Participant> participant = participantRepository.findById((long) participantId);
        return discipline.flatMap(discipline1 -> participant.map(participant1 -> new Result(discipline1, participant1, result, resultType, date))).orElse(null);
    }
}
