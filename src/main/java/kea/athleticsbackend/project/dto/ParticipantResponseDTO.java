package kea.athleticsbackend.project.dto;

import kea.athleticsbackend.project.model.Participant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParticipantResponseDTO {
    private int id;
    private String name;
    private int age;
    private String club;

    public ParticipantResponseDTO() {
    }

    public ParticipantResponseDTO(int id, String name, int age, String club) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.club = club;
    }

    public ParticipantResponseDTO(Participant participant) {
        this.id = participant.getId();
        this.name = participant.getName();
        this.age = participant.getAge();
        this.club = participant.getClub();
    }
}
