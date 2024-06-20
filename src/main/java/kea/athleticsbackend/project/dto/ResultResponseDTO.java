package kea.athleticsbackend.project.dto;

import kea.athleticsbackend.project.model.Result;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultResponseDTO {
    private String discipline;
    private String participant;
    private String result;

    public ResultResponseDTO(String discipline, String participant, String result) {
        this.discipline = discipline;
        this.participant = participant;
        this.result = result;
    }


}
