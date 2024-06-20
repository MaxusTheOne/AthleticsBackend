package kea.athleticsbackend.project;

import kea.athleticsbackend.project.model.Result;
import kea.athleticsbackend.project.model.Participant;
import kea.athleticsbackend.project.model.Discipline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ResultTests {

    private Result result;

    @BeforeEach
    public void setup() {
        result = new Result();
    }

    @Test
    public void resultHasCorrectDate() {
        result.setDate("2023-03-01");
        assertEquals("2023-03-01", result.getDate());
    }

    @Test
    public void resultHasCorrectValue() {
        result.setResultValue("10.5");
        assertEquals("10.5", result.getResultValue());
    }

    @Test
    public void resultCanHaveParticipant() {
        Participant participant = new Participant();
        result.setParticipant(participant);
        assertEquals(participant, result.getParticipant());
    }

    @Test
    public void resultCanBeWithoutParticipant() {
        result.setParticipant(null);
        assertNull(result.getParticipant());
    }

    @Test
    public void resultHasCorrectDiscipline() {
        Discipline discipline = new Discipline();
        result.setDiscipline(discipline);
        assertEquals(discipline, result.getDiscipline());
    }
}