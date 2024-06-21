package kea.athleticsbackend.project.controller;

import kea.athleticsbackend.project.dto.DisciplineRequestDTO;
import kea.athleticsbackend.project.dto.DisciplineResponseDTO;
import kea.athleticsbackend.project.service.DisciplineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplines")
public class DisciplineController {

    private final DisciplineService disciplineService;

    public DisciplineController(DisciplineService disciplineService) {
        this.disciplineService = disciplineService;
    }

    @GetMapping("")
    public ResponseEntity<List<DisciplineResponseDTO>> getAllDisciplines() {
        System.out.println("Getting all disciplines");
        return ResponseEntity.ok(disciplineService.getAllDisciplines());
    }

    @GetMapping("/{id}")
    public DisciplineResponseDTO getDisciplineById(@PathVariable long id) {
        return disciplineService.getById(id);
    }

    @PostMapping
    public ResponseEntity<DisciplineResponseDTO> addDiscipline(DisciplineRequestDTO discipline) {
        return ResponseEntity.ok(disciplineService.addDiscipline(discipline));
    }

    @DeleteMapping("/{id}")
    public void deleteDiscipline(@PathVariable long id) {
        disciplineService.deleteDiscipline(id);
    }
}
