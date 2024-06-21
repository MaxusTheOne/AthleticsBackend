package kea.athleticsbackend.project.dto;

import kea.athleticsbackend.project.model.Discipline;
import kea.athleticsbackend.project.model.Result;
import kea.athleticsbackend.project.repository.ResultRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.util.Pair;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Setter
@Getter
public class DisciplineResponseDTO {
    private Long id;
    private String disciplineName;
    private String disciplineType;
    private List<Integer> resultsId;



    public DisciplineResponseDTO(Long id, String disciplineName, String disciplineType, List<Integer> resultsId) {
        this.id = id;
        this.disciplineName = disciplineName;
        this.disciplineType = disciplineType;
        this.resultsId = resultsId;


    }

    public DisciplineResponseDTO(Discipline discipline) {
        this.disciplineName = discipline.getName();
        this.disciplineType = discipline.getResultType();
        if (discipline.getResults() != null) this.resultsId = discipline.getResults().stream().map(Result::getId).toList();
        else this.resultsId = null;

    }


    public Discipline toDiscipline(ResultRepository resultRepository){
        return new Discipline(disciplineName, disciplineType, resultsId, resultRepository);
    }
}
