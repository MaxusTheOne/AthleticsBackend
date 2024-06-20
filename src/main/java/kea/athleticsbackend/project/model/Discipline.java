package kea.athleticsbackend.project.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Discipline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private ResultType resultType;
    @ManyToMany
    private List<Participant> participants;
    @OneToMany
    @JoinColumn(name = "discipline_id")
    private List<Result> results;
}
