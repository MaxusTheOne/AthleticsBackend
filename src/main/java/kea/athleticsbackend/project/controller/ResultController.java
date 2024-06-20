package kea.athleticsbackend.project.controller;

import kea.athleticsbackend.project.dto.ResultResponseDTO;
import kea.athleticsbackend.project.service.ResultService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/result")
public class ResultController {

    private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    public List<ResultResponseDTO> getAllResults() {
        return resultService.getAll();
    }

    public ResultResponseDTO getResultById(Long id) {
        return resultService.getById(id);
    }


}
