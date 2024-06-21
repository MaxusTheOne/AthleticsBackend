package kea.athleticsbackend.project.dto;

import kea.athleticsbackend.project.model.Discipline;
import kea.athleticsbackend.project.model.Participant;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ParticipantResponseDTO {
    private int id;
    private String name;
    private int age;
    private String club;
    private List<String> disciplines;

    public ParticipantResponseDTO() {
    }

    public ParticipantResponseDTO(int id, String name, int age, String club, List<String> disciplines) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.club = club;
        this.disciplines = disciplines;

    }

    public ParticipantResponseDTO(Participant participant) {
        this.id = participant.getId();
        this.name = participant.getName();
        this.age = participant.getAge();
        this.club = participant.getClub();
        if (participant.getDisciplines() != null) {
            this.disciplines = participant.getDisciplines().stream().map(Discipline::getName).toList();
        } else {
            this.disciplines = null;
        }
    }
}
