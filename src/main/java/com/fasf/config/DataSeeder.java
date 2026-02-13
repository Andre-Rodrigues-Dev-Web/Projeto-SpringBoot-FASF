package com.fasf.config;

import com.fasf.model.Student;
import com.fasf.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Configuration
public class DataSeeder implements CommandLineRunner {

    private final StudentRepository studentRepository;

    public DataSeeder(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (studentRepository.count() == 0) {
            Student s1 = Student.builder()
                    .name("André Laurentino")
                    .email("andre@fasf.com")
                    .enrollmentDate(LocalDate.now().minusDays(30))
                    .createdAt(LocalDateTime.now())
                    .build();
            studentRepository.save(s1);

            Student s2 = Student.builder()
                    .name("Maria Silva")
                    .email("maria@fasf.com")
                    .enrollmentDate(LocalDate.now().minusMonths(6))
                    .createdAt(LocalDateTime.now())
                    .build();
            studentRepository.save(s2);

            Student s3 = Student.builder()
                    .name("João Souza")
                    .email("joao@fasf.com")
                    .enrollmentDate(LocalDate.now().minusYears(1))
                    .createdAt(LocalDateTime.now())
                    .build();
            studentRepository.save(s3);

            Student s4 = Student.builder()
                    .name("Ana Costa")
                    .email("ana@fasf.com")
                    .enrollmentDate(LocalDate.of(2023, 3, 15))
                    .createdAt(LocalDateTime.now())
                    .build();
            studentRepository.save(s4);

            Student s5 = Student.builder()
                    .name("Pedro Santos")
                    .email("pedro@fasf.com")
                    .enrollmentDate(LocalDate.of(2024, 1, 10))
                    .createdAt(LocalDateTime.now())
                    .build();
            studentRepository.save(s5);
            
            System.out.println("✅ Mock data loaded: 5 students created.");
        }
    }
}
