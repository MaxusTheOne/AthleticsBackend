package kea.athleticsbackend.project.configuration;

import kea.athleticsbackend.project.dto.ParticipantRequestDTO;
import kea.athleticsbackend.project.service.ParticipantService;

public class SetupTestParticipants {

    private final ParticipantService participantService;

    public SetupTestParticipants(ParticipantService participantService) {
        this.participantService = participantService;
    }

    public void setup() {
        participantService.saveParticipant(new ParticipantRequestDTO("Max", 20, "KEA"));
        participantService.saveParticipant(new ParticipantRequestDTO("John", 25, "KEA"));
        participantService.saveParticipant(new ParticipantRequestDTO("Peter", 30, "KEA"));
        participantService.saveParticipant(new ParticipantRequestDTO("Sara", 35, "KBH"));
        participantService.saveParticipant(new ParticipantRequestDTO("Lena", 40, "KBH"));
        participantService.saveParticipant(new ParticipantRequestDTO("Mia", 45, "KBH"));
    }
}
