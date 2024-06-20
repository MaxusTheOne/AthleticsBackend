package kea.athleticsbackend.project.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    @JoinColumn(name = "participant_id")
    private Discipline discipline;
}
