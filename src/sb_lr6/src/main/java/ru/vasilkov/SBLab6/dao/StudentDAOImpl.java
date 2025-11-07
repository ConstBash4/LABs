package ru.vasilkov.SBLab6.dao;

import jakarta.persistence.NoResultException;
import ru.vasilkov.SBLab6.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Student> getAllStudents() {
        try {
            Query query = entityManager.createQuery("from Student");
            List<Student> allStudents = query.getResultList();
            log.info("getAllStudents: {}", allStudents);
            return allStudents;
        } catch (Exception e) {
            log.error("ошибка при получении списка Student", e);
            throw new RuntimeException("ошибка при получении списка Student", e);
        }
    }

    @Override
    public Student getStudent(int id) {
        Student student;
        try {
            student = entityManager.find(Student.class, id);
        } catch (Exception e) {
            log.error("ошибка при поиске Student", e);
            throw new RuntimeException("ошибка при поиске Student", e);
        }
        if (student == null) {
            log.warn("Student с id={} не найден", id);
            throw new NoResultException("Student с id=" + id + " не найден");
        }
        log.info("Student с id={} найден", id);
        return student;
    }

    @Override
    public Student saveStudent(Student student) {
        if (student == null) {
            log.warn("попытка сохранить null-объект Student");
            throw new IllegalArgumentException("Student не может быть null");
        }
        try {
            return entityManager.merge(student);
        } catch (Exception e) {
            log.error("ошибка при сохранении Student", e);
            throw e;
        }
    }

    @Override
    public void deleteStudent(int id) {
        Student student = getStudent(id);
        try {
            entityManager.remove(student);
            log.info("Student с id={} удален", id);
        } catch (Exception e) {
            log.error("ошибка при удалении Student", e);
            throw new RuntimeException("ошибка при удалении Student", e);
        }
    }
}
