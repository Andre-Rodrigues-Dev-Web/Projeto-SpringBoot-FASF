package com.fasf.controller;

import com.fasf.dto.StudentRequestDTO;
import com.fasf.dto.StudentResponseDTO;
import com.fasf.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@Tag(name = "Student Management", description = "Endpoints para gestão de alunos com boas práticas")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all")
    @Operation(summary = "Listar todos os alunos (sem paginação)")
    public ResponseEntity<List<StudentResponseDTO>> getAllStudents() {
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping
    @Operation(summary = "Listar alunos com paginação e ordenação")
    public ResponseEntity<Page<StudentResponseDTO>> getStudentsPaged(
            @Parameter(description = "Configuração de paginação (page, size, sort)") Pageable pageable) {
        return ResponseEntity.ok(studentService.findAll(pageable));
    }

    @GetMapping("/{id}")
    @Operation(
        summary = "Obter aluno por ID",
        responses = {
            @ApiResponse(responseCode = "200", description = "Aluno encontrado"),
            @ApiResponse(responseCode = "404", description = "Aluno não encontrado", content = @Content(schema = @Schema(implementation = com.fasf.exception.ErrorDetails.class)))
        }
    )
    public ResponseEntity<StudentResponseDTO> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Criar um novo aluno")
    public ResponseEntity<StudentResponseDTO> createStudent(@Valid @RequestBody StudentRequestDTO studentDTO) {
        return new ResponseEntity<>(studentService.save(studentDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um aluno existente")
    public ResponseEntity<StudentResponseDTO> updateStudent(
            @PathVariable Long id, 
            @Valid @RequestBody StudentRequestDTO studentDTO) {
        return ResponseEntity.ok(studentService.update(id, studentDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar um aluno")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
