package kea.athleticsbackend.project.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import kea.athleticsbackend.project.repository.ResultRepository;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
@Entity
public class Discipline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String resultType;
    @ManyToMany(mappedBy = "disciplines")
    private List<Participant> participants;
    @Nullable
    @OneToMany
    private List<Result> results;

    public Discipline() {
    }
    public Discipline(int disciplineId) {
        this.id = disciplineId;
    }

    public Discipline(String disciplineName, String disciplineType, List<Integer> resultsId, ResultRepository resultsRepository){
        this.name = disciplineName;
        this.resultType = disciplineType;
        if (resultsId != null) {
            for (int resultId : resultsId) {
                this.results.add(resultsRepository.findById((long) resultId).orElseGet(null));
            }
        } else {
            this.results = null;
        }

    }
}
