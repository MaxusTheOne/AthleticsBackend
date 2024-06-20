package kea.athleticsbackend.project.dto;

import kea.athleticsbackend.project.model.Participant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParticipantRequestDTO {

    private String name;
    private int age;
    private String club;

    public ParticipantRequestDTO() {
    }

    public ParticipantRequestDTO(String name, int age, String club) {
        this.name = name;
        this.age = age;
        this.club = club;
    }

    public Participant toParticipant() {
        return new Participant(name, age, club);
    }
}
