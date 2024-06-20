package kea.athleticsbackend.project.service;

import kea.athleticsbackend.project.dto.DisciplineRequestDTO;
import kea.athleticsbackend.project.dto.DisciplineResponseDTO;
import kea.athleticsbackend.project.model.Result;
import kea.athleticsbackend.project.repository.DisciplineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplineService {

    private final DisciplineRepository disciplineRepository;
    private final ResultService resultService;

    public DisciplineService(DisciplineRepository disciplineRepository, ResultService resultService) {
        this.disciplineRepository = disciplineRepository;

        this.resultService = resultService;
    }

    public List<DisciplineResponseDTO> getAllDisciplines() {
        return disciplineRepository.findAll().stream()
                .map(discipline -> new DisciplineResponseDTO(discipline.getName(), discipline.getResultType(), discipline.getResults().stream().map(Result::getId).toList()))
                .collect(java.util.stream.Collectors.toList());
    }

    public DisciplineResponseDTO getById(Long id) {
        return disciplineRepository.findById(id)
                .map(discipline -> new DisciplineResponseDTO(discipline.getName(), discipline.getResultType(), discipline.getResults().stream().map(Result::getId).toList()))
                .orElseThrow(() -> new IllegalArgumentException("Discipline with id " + id + " not found"));
    }

    // I know I do this differently in the other services, but you can't stop me
    public DisciplineResponseDTO addDiscipline(DisciplineRequestDTO discipline) {
        return new DisciplineResponseDTO( disciplineRepository.save(discipline.toDiscipline(resultService.getResultRepository())));
    }

    public void createDiscipline(String name, String resultType) {
        disciplineRepository.save(new DisciplineRequestDTO(name, resultType, Optional.empty()).toDiscipline(resultService.getResultRepository()));
    }

    public void saveDiscipline(String s, String sprint) {
        createDiscipline(s, sprint);
    }
}
