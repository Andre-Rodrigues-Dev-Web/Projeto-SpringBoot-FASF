package com.fasf.service.impl;

import com.fasf.dto.StudentRequestDTO;
import com.fasf.dto.StudentResponseDTO;
import com.fasf.exception.ResourceNotFoundException;
import com.fasf.mapper.StudentMapper;
import com.fasf.model.Student;
import com.fasf.repository.StudentRepository;
import com.fasf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public List<StudentResponseDTO> findAll() {
        return studentRepository.findAll().stream()
                .map(studentMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Page<StudentResponseDTO> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable)
                .map(studentMapper::toResponseDTO);
    }

    @Override
    public StudentResponseDTO findById(Long id) {
        return studentRepository.findById(id)
                .map(studentMapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado com id: " + id));
    }

    @Override
    public StudentResponseDTO save(StudentRequestDTO studentDTO) {
        Student student = studentMapper.toEntity(studentDTO);
        Student savedStudent = studentRepository.save(student);
        return studentMapper.toResponseDTO(savedStudent);
    }

    @Override
    public StudentResponseDTO update(Long id, StudentRequestDTO studentDTO) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado com id: " + id));

        studentMapper.updateEntityFromDTO(studentDTO, existingStudent);
        Student updatedStudent = studentRepository.save(existingStudent);
        return studentMapper.toResponseDTO(updatedStudent);
    }

    @Override
    public void delete(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Aluno não encontrado com id: " + id);
        }
        studentRepository.deleteById(id);
    }
}
