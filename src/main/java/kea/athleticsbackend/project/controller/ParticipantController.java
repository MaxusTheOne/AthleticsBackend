package kea.athleticsbackend.project.controller;

import kea.athleticsbackend.project.dto.ParticipantRequestDTO;
import kea.athleticsbackend.project.dto.ParticipantResponseDTO;
import kea.athleticsbackend.project.service.ParticipantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/participants")
public class ParticipantController {

    private final ParticipantService participantService;

    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @GetMapping
    public List<ParticipantResponseDTO> getAllParticipants() {
        System.out.println("Getting all participants");
        return participantService.getAll();
    }

    @GetMapping("/{id}")
    public ParticipantResponseDTO getParticipantById(@PathVariable Long id) {
        return participantService.getById(id);
    }

    @PostMapping
    public ParticipantResponseDTO saveParticipant(@RequestBody ParticipantRequestDTO participantRequestDTO) {
        return participantService.saveParticipant(participantRequestDTO);
    }

    @PutMapping("/{id}")
    public ParticipantResponseDTO updateParticipant(@PathVariable Long id, @RequestBody ParticipantRequestDTO participantRequestDTO) {
        return participantService.updateParticipant(id, participantRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteParticipant(@PathVariable Long id) {
        participantService.deleteParticipant(id);
    }
}
