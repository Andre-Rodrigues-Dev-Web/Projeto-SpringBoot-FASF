package com.fasf.mapper;

import com.fasf.dto.StudentRequestDTO;
import com.fasf.dto.StudentResponseDTO;
import com.fasf.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public Student toEntity(StudentRequestDTO dto) {
        if (dto == null) return null;
        return Student.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .enrollmentDate(dto.getEnrollmentDate())
                .build();
    }

    public StudentResponseDTO toResponseDTO(Student entity) {
        if (entity == null) return null;
        return StudentResponseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .enrollmentDate(entity.getEnrollmentDate())
                .build();
    }

    public void updateEntityFromDTO(StudentRequestDTO dto, Student entity) {
        if (dto == null || entity == null) return;
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setEnrollmentDate(dto.getEnrollmentDate());
    }
}
