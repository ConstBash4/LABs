package ru.vasilkov.Lab7Application.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vasilkov.Lab7Application.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
