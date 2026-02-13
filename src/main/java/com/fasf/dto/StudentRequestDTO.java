package com.fasf.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;
import java.util.Objects;

public class StudentRequestDTO {

    @NotBlank(message = "O nome é obrigatório")
    private String name;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @NotNull(message = "A data de matrícula é obrigatória")
    @PastOrPresent(message = "A data de matrícula não pode ser no futuro")
    private LocalDate enrollmentDate;

    public StudentRequestDTO() {
    }

    public StudentRequestDTO(String name, String email, LocalDate enrollmentDate) {
        this.name = name;
        this.email = email;
        this.enrollmentDate = enrollmentDate;
    }

    public static StudentRequestDTOBuilder builder() {
        return new StudentRequestDTOBuilder();
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
        StudentRequestDTO that = (StudentRequestDTO) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(email, that.email) &&
                Objects.equals(enrollmentDate, that.enrollmentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, enrollmentDate);
    }

    @Override
    public String toString() {
        return "StudentRequestDTO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", enrollmentDate=" + enrollmentDate +
                '}';
    }

    public static class StudentRequestDTOBuilder {
        private String name;
        private String email;
        private LocalDate enrollmentDate;

        StudentRequestDTOBuilder() {
        }

        public StudentRequestDTOBuilder name(String name) {
            this.name = name;
            return this;
        }

        public StudentRequestDTOBuilder email(String email) {
            this.email = email;
            return this;
        }

        public StudentRequestDTOBuilder enrollmentDate(LocalDate enrollmentDate) {
            this.enrollmentDate = enrollmentDate;
            return this;
        }

        public StudentRequestDTO build() {
            return new StudentRequestDTO(name, email, enrollmentDate);
        }
    }
}
