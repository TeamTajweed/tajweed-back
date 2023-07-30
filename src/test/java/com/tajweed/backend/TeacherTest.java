package com.tajweed.backend;

import com.tajweed.backend.controller.TeacherController;
import com.tajweed.backend.dao.TeacherRepository;
import com.tajweed.backend.model.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TeacherController.class)
public class TeacherTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TeacherRepository repository;


    @Test
    @WithMockUser(value = "user")
    public void givenConnectedThenShouldReturnAllTeachers() throws Exception {
        when(repository.findAll()).thenReturn(List.of(new Teacher("A", "A teacher" )));
        this.mockMvc.perform(get("/teachers"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[{'id': 'A', 'resume': 'A teacher'}]"));
    }

    @Test
    public void givenNotConnectedThenShouldReturn401() throws Exception {
        when(repository.findAll()).thenReturn(List.of(new Teacher("A", "A teacher" )));
        this.mockMvc.perform(get("/teachers"))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }
}
