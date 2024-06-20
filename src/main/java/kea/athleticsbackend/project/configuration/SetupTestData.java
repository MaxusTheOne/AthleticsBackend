package kea.athleticsbackend.project.configuration;


import kea.athleticsbackend.project.service.DisciplineService;
import kea.athleticsbackend.project.service.ParticipantService;
import kea.athleticsbackend.project.service.ResultService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SetupTestData implements ApplicationRunner {

    public final ParticipantService participantService;
    public final ResultService resultService;
    public final DisciplineService disciplineService;


    public SetupTestData(ParticipantService participantService, ResultService resultService, DisciplineService disciplineService) {
        this.participantService = participantService;
        this.resultService = resultService;
        this.disciplineService = disciplineService;
    }


    public void run(ApplicationArguments args) {
        new SetupTestDisciplines(disciplineService).setup();
        new SetupTestParticipants(participantService).setup();
        new SetupTestResults(resultService).setup();
    }
}
