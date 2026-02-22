package it.unicam.cs.hackhub.core.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ApiInfoController.class)
class ApiInfoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void info_returnsOk() throws Exception {
        mockMvc.perform(get("/api/v1"))
                .andExpect(status().isOk());
    }
}
