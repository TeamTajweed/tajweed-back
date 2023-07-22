package com.tajweed.backend;

import com.tajweed.backend.controller.StudentController;
import com.tajweed.backend.dao.StudentRepository;
import com.tajweed.backend.model.Student;
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

@WebMvcTest(StudentController.class)
public class StudentTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentRepository repository;


    @Test
    @WithMockUser(value = "user")
    public void givenConnectedThenShouldReturnAllStudents() throws Exception {
        when(repository.findAll()).thenReturn(List.of(new Student(1L, "Fodil", "A")));
        this.mockMvc.perform(get("/students"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[{'id': 1, 'name': 'Fodil', 'surname': 'A'}]"));
    }

    @Test
    public void givenNotConnectedThenShouldReturn401() throws Exception {
        when(repository.findAll()).thenReturn(List.of(new Student(1L, "Fodil", "A")));
        this.mockMvc.perform(get("/students"))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }
}
