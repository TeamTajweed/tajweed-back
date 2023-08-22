package com.tajweed.backend;

import com.tajweed.backend.controller.EntityController;
import com.tajweed.backend.dao.EntityRepository;
import com.tajweed.backend.model.Entity;
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

@WebMvcTest(EntityController.class)
public class EntityTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EntityRepository repository;


    @Test
    @WithMockUser(value = "user")
    public void givenConnectedThenShouldReturnAllEntity() throws Exception {
        when(repository.findAll()).thenReturn(List.of(new Entity("A", true)));
        this.mockMvc.perform(get("/api/entities"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[{'id': 'A', 'isActive': true}]"));
    }

    @Test
    public void givenNotConnectedThenShouldReturn401() throws Exception {
        when(repository.findAll()).thenReturn(List.of(new Entity("A", true)));
        this.mockMvc.perform(get("/api/entities"))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }
}
