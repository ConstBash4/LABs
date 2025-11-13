package ru.vasilkov.Lab8Application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vasilkov.Lab8Application.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
