package kea.athleticsbackend.project;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ResultControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllResultsReturnsOk() throws Exception {
        mockMvc.perform(get("/results"))
                .andExpect(status().isOk());
    }

    @Test
    public void getResultByIdReturnsOk() throws Exception {
        mockMvc.perform(get("/results/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void getResultByInvalidIdReturnsNotFound() throws Exception {
        mockMvc.perform(get("/results/9999"))
                .andExpect(status().isNotFound());
    }
}
