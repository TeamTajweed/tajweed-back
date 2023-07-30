package com.tajweed.backend;

import com.tajweed.backend.controller.AudioController;
import com.tajweed.backend.dao.AudioRepository;
import com.tajweed.backend.model.Audio;
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

@WebMvcTest(AudioController.class)


public class AudioTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AudioRepository repository;

    @Test
    @WithMockUser()
    public void givenConnectedThenShouldReturnAllAudio() throws Exception {
        when(repository.findAll()).thenReturn(List.of(new Audio("A", new Student(), "idEntity" , "baqarah", "180")));
        this.mockMvc.perform(get("/audio"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[{'id': 'A', 'idStudent': 'idStudent', 'idEntity': 'idEntity' , 'chapter': 'baqarah' , 'verse': '180'}]"));

    }

    @Test
    public void givenNotConnectedThenShouldReturn401() throws Exception {

        when(repository.findAll()).thenReturn(List.of(new Audio("A", new Student(), "idEntity" , "baqarah" , "180")));

        this.mockMvc.perform(get("/audio"))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }
}
