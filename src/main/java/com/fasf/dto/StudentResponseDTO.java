package com.fasf.dto;

import java.time.LocalDate;
import java.util.Objects;

public class StudentResponseDTO {
    private Long id;
    private String name;
    private String email;
    private LocalDate enrollmentDate;

    public StudentResponseDTO() {
    }

    public StudentResponseDTO(Long id, String name, String email, LocalDate enrollmentDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.enrollmentDate = enrollmentDate;
    }

    public static StudentResponseDTOBuilder builder() {
        return new StudentResponseDTOBuilder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentResponseDTO that = (StudentResponseDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(email, that.email) &&
                Objects.equals(enrollmentDate, that.enrollmentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, enrollmentDate);
    }

    @Override
    public String toString() {
        return "StudentResponseDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", enrollmentDate=" + enrollmentDate +
                '}';
    }

    public static class StudentResponseDTOBuilder {
        private Long id;
        private String name;
        private String email;
        private LocalDate enrollmentDate;

        StudentResponseDTOBuilder() {
        }

        public StudentResponseDTOBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public StudentResponseDTOBuilder name(String name) {
            this.name = name;
            return this;
        }

        public StudentResponseDTOBuilder email(String email) {
            this.email = email;
            return this;
        }

        public StudentResponseDTOBuilder enrollmentDate(LocalDate enrollmentDate) {
            this.enrollmentDate = enrollmentDate;
            return this;
        }

        public StudentResponseDTO build() {
            return new StudentResponseDTO(id, name, email, enrollmentDate);
        }
    }
}
