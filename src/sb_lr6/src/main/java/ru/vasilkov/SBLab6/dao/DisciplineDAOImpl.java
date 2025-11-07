package ru.vasilkov.SBLab6.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.vasilkov.SBLab6.entity.Discipline;

import java.util.List;

@Slf4j
@Repository
public class DisciplineDAOImpl implements DisciplineDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Discipline> getAllDisciplines() {
        try {
            Query query = entityManager.createQuery("from Discipline");
            List<Discipline> allDisciplines = query.getResultList();
            log.info("getAllDisciplines: {}", allDisciplines);
            return allDisciplines;
        } catch (Exception e) {
            log.error("ошибка при получении списка Discipline", e);
            throw new RuntimeException("ошибка при получении списка Discipline", e);
        }
    }

    @Override
    public Discipline getDiscipline(int id) {
        Discipline discipline;
        try {
            discipline = entityManager.find(Discipline.class, id);
        } catch (Exception e) {
            log.error("ошибка при поиске Discipline", e);
            throw new RuntimeException("ошибка при поиске Discipline", e);
        }
        if (discipline == null) {
            log.warn("Discipline с id={} не найден", id);
            throw new NoResultException("Discipline с id=" + id + " не найден");
        }
        log.info("Discipline с id={} найден", id);
        return discipline;
    }

    @Override
    public Discipline saveDiscipline(Discipline discipline) {
        if (discipline == null) {
            log.warn("попытка сохранить null-объект Discipline");
            throw new IllegalArgumentException("Discipline не может быть null");
        }
        try {
            return entityManager.merge(discipline);
        } catch (Exception e) {
            log.error("ошибка при сохранении Discipline", e);
            throw e;
        }
    }

    @Override
    public void deleteDiscipline(int id) {
        Discipline discipline = getDiscipline(id);
        try {
            entityManager.remove(discipline);
            log.info("Discipline с id={} удален", id);
        } catch (Exception e) {
            log.error("ошибка при удалении Discipline", e);
            throw new RuntimeException("ошибка при удалении Discipline", e);
        }
    }
}
