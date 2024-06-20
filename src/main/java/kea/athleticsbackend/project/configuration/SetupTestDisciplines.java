package kea.athleticsbackend.project.configuration;

import kea.athleticsbackend.project.service.DisciplineService;

public class SetupTestDisciplines {

    private final DisciplineService disciplineService;

    public SetupTestDisciplines(DisciplineService disciplineService) {
        this.disciplineService = disciplineService;
    }

    public void setup() {
        disciplineService.saveDiscipline("100m", "Sprint");
        disciplineService.saveDiscipline("200m", "Sprint");
        disciplineService.saveDiscipline("400m", "Sprint");
        disciplineService.saveDiscipline("800m", "Middle distance");
        disciplineService.saveDiscipline("1500m", "Middle distance");
        disciplineService.saveDiscipline("5000m", "Long distance");
        disciplineService.saveDiscipline("10000m", "Long distance");
        disciplineService.saveDiscipline("110m hurdles", "Hurdles");
        disciplineService.saveDiscipline("400m hurdles", "Hurdles");
        disciplineService.saveDiscipline("High jump", "Jump");
    }
}
