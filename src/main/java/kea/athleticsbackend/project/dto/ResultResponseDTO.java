package kea.athleticsbackend.project.dto;

import kea.athleticsbackend.project.model.Result;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultResponseDTO {
    private Long id;
    private String discipline;
    private String participant;
    private String result;

    public ResultResponseDTO(Long id, String discipline, String participant, String result) {
        this.id = id;
        this.discipline = discipline;
        this.participant = participant;
        this.result = result;
    }


}
