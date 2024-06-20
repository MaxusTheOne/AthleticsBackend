package kea.athleticsbackend.project.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private String club;
    @ManyToMany
    @JoinTable(name = "participant_disciplines",
            joinColumns = @JoinColumn(name = "participant_id"),
            inverseJoinColumns = @JoinColumn(name = "discipline_id"))
    private List<Discipline> disciplines;

    public Participant() {
    }
    public Participant(int participantId) {
        this.id = participantId;
    }

    public Participant(String name, int age, String club) {
        this.name = name;
        this.age = age;
        this.club = club;
    }
}
