package kea.athleticsbackend.project.dto;

import jakarta.annotation.Nullable;
import kea.athleticsbackend.project.model.Discipline;
import kea.athleticsbackend.project.repository.ResultRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.util.Pair;

import java.util.List;
import java.util.Optional;

@Setter
@Getter
public class DisciplineRequestDTO {
    private String disciplineName;
    private String disciplineType;
    @Nullable
    private List<Integer> results;



    public DisciplineRequestDTO(String disciplineName, String disciplineType, Optional<List<Integer>> results) {
        this.disciplineName = disciplineName;
        this.disciplineType = disciplineType;
        this.results = results.orElse(null);


    }


    public Discipline toDiscipline(ResultRepository resultRepository){
        return new Discipline(disciplineName, disciplineType, results, resultRepository);
    }
}
