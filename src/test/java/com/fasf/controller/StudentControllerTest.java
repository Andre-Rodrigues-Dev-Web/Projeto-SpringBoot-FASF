package com.fasf.controller;

import com.fasf.dto.StudentRequestDTO;
import com.fasf.dto.StudentResponseDTO;
import com.fasf.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Autowired
    private ObjectMapper objectMapper;

    private StudentResponseDTO responseDTO;
    private StudentRequestDTO requestDTO;

    @BeforeEach
    void setUp() {
        responseDTO = StudentResponseDTO.builder()
                .id(1L)
                .name("Alice Smith")
                .email("alice@email.com")
                .enrollmentDate(LocalDate.now())
                .build();

        requestDTO = StudentRequestDTO.builder()
                .name("Alice Smith")
                .email("alice@email.com")
                .enrollmentDate(LocalDate.now())
                .build();
    }

    @Test
    void shouldGetAllStudents() throws Exception {
        when(studentService.findAll()).thenReturn(List.of(responseDTO));

        mockMvc.perform(get("/api/students/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Alice Smith"));
    }

    @Test
    void shouldCreateStudent() throws Exception {
        when(studentService.save(any(StudentRequestDTO.class))).thenReturn(responseDTO);

        mockMvc.perform(post("/api/students")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.email").value("alice@email.com"));
    }

    @Test
    void shouldReturnBadRequestWhenNameIsBlank() throws Exception {
        requestDTO.setName("");

        mockMvc.perform(post("/api/students")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Falha na validação de dados"))
                .andExpect(jsonPath("$.validationErrors.name").value("O nome é obrigatório"));
    }

    @Test
    void shouldUpdateStudent() throws Exception {
        when(studentService.update(eq(1L), any(StudentRequestDTO.class))).thenReturn(responseDTO);

        mockMvc.perform(put("/api/students/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isOk());
    }

    @Test
    void shouldDeleteStudent() throws Exception {
        mockMvc.perform(delete("/api/students/1"))
                .andExpect(status().isNoContent());
    }
}
