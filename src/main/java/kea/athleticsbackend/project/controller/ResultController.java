package kea.athleticsbackend.project.controller;

import kea.athleticsbackend.project.dto.ResultRequestDTO;
import kea.athleticsbackend.project.dto.ResultResponseDTO;
import kea.athleticsbackend.project.service.ResultService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/result")
public class ResultController {

    private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping
    public List<ResultResponseDTO> getAllResults() {
        return resultService.getAll();
    }

    @GetMapping("/{id}")
    public ResultResponseDTO getResultById(@PathVariable Long id) {
        return resultService.getById(id);
    }

    @PostMapping
    public void saveResult(@RequestBody ResultRequestDTO resultRequestDTO) {
        resultService.saveResult(resultRequestDTO);
    }

    @PostMapping("/multiple")
    public void saveMultipleResults(@RequestBody List<ResultRequestDTO> resultRequestDTOs) {
        resultRequestDTOs.forEach(resultService::saveResult);
    }

    @PutMapping("/{id}")
    public void updateResult(@PathVariable Long id, @RequestBody ResultRequestDTO resultRequestDTO) {
        resultService.updateResult(id, resultRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteResult(@PathVariable Long id) {
        resultService.deleteResult(id);
    }

}
