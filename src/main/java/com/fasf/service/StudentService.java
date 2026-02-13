package com.fasf.service;

import com.fasf.dto.StudentRequestDTO;
import com.fasf.dto.StudentResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {
    List<StudentResponseDTO> findAll();
    Page<StudentResponseDTO> findAll(Pageable pageable);
    StudentResponseDTO findById(Long id);
    StudentResponseDTO save(StudentRequestDTO studentDTO);
    StudentResponseDTO update(Long id, StudentRequestDTO studentDTO);
    void delete(Long id);
}
