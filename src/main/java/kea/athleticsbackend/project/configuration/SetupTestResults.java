package kea.athleticsbackend.project.configuration;

import kea.athleticsbackend.project.dto.ResultRequestDTO;
import kea.athleticsbackend.project.service.ResultService;

public class SetupTestResults {

    public final ResultService resultService;

    public SetupTestResults(ResultService resultService) {
        this.resultService = resultService;
    }

    public void setup(){
        resultService.saveResult(new ResultRequestDTO(1L, 2L, "100m", "20-10-2020", "10.5", "Time"));
        resultService.saveResult(new ResultRequestDTO(2L, 3L, "200m", "20-10-2020", "20.5", "Time"));
        resultService.saveResult(new ResultRequestDTO(3L, 4L, "400m", "20-10-2020", "30.5", "Time"));
        resultService.saveResult(new ResultRequestDTO(4L, 5L, "800m", "20-10-2020", "3", "Placement"));
    }
}
