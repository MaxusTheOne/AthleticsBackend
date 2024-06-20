package kea.athleticsbackend.project.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@Entity
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private ResultType resultType;
    private String date;
    private String resultValue;
    @ManyToOne
    private Discipline discipline;
    @ManyToOne(optional = true)
    private Participant participant;

    public Result() {
    }

    // Rewrite this later to use repository

    public Result(Discipline discipline, Participant participant, String result, String resultType, String date) {
        this.discipline = discipline;
        this.participant = participant;
        this.resultValue = result;
        this.resultType = ResultType.valueOf(resultType);
        this.date = date;
    }

    public Result(int resultId, int disciplineId, int participantId, String result) {
        this.id = resultId;
        this.discipline = new Discipline(disciplineId);
        this.participant = new Participant(participantId);
        this.resultValue = result;
    }

    public String getResultType(){
        return this.resultType.name();
    }
}
