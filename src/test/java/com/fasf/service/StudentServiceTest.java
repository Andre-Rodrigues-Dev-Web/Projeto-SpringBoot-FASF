package com.fasf.service;

import com.fasf.dto.StudentRequestDTO;
import com.fasf.dto.StudentResponseDTO;
import com.fasf.mapper.StudentMapper;
import com.fasf.model.Student;
import com.fasf.repository.StudentRepository;
import com.fasf.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @Spy
    private StudentMapper studentMapper;

    @InjectMocks
    private StudentServiceImpl studentService;

    private Student student;
    private StudentRequestDTO requestDTO;

    @BeforeEach
    void setUp() {
        student = Student.builder()
                .id(1L)
                .name("João Silva")
                .email("joao@email.com")
                .enrollmentDate(LocalDate.now())
                .build();

        requestDTO = StudentRequestDTO.builder()
                .name("João Silva")
                .email("joao@email.com")
                .enrollmentDate(LocalDate.now())
                .build();
    }

    @Test
    void shouldFindAllStudents() {
        when(studentRepository.findAll()).thenReturn(List.of(student));

        List<StudentResponseDTO> students = studentService.findAll();

        assertThat(students).hasSize(1);
        assertThat(students.get(0).getName()).isEqualTo("João Silva");
    }

    @Test
    void shouldFindStudentById() {
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

        StudentResponseDTO found = studentService.findById(1L);

        assertThat(found.getName()).isEqualTo("João Silva");
    }

    @Test
    void shouldSaveStudent() {
        when(studentRepository.save(any(Student.class))).thenReturn(student);

        StudentResponseDTO saved = studentService.save(requestDTO);

        assertThat(saved).isNotNull();
        assertThat(saved.getEmail()).isEqualTo("joao@email.com");
    }

    @Test
    void shouldUpdateStudent() {
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));
        when(studentRepository.save(any(Student.class))).thenReturn(student);

        requestDTO.setName("João Atualizado");
        StudentResponseDTO updated = studentService.update(1L, requestDTO);

        assertThat(updated.getName()).isEqualTo("João Atualizado");
    }

    @Test
    void shouldDeleteStudent() {
        when(studentRepository.existsById(1L)).thenReturn(true);
        doNothing().when(studentRepository).deleteById(1L);

        studentService.delete(1L);

        verify(studentRepository, times(1)).deleteById(1L);
    }
}
