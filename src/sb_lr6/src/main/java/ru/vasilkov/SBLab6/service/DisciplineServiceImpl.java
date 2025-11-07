package ru.vasilkov.SBLab6.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vasilkov.SBLab6.dao.DisciplineDAO;
import ru.vasilkov.SBLab6.entity.Discipline;

import java.util.List;

@Service
public class DisciplineServiceImpl implements DisciplineService {
    @Autowired
    private DisciplineDAO DisciplineDAO;

    @Override
    @Transactional
    public List<Discipline> getAllDisciplines() {return DisciplineDAO.getAllDisciplines();}

    @Override
    @Transactional
    public Discipline saveDiscipline(Discipline discipline) {return DisciplineDAO.saveDiscipline(discipline);}

    @Override
    @Transactional
    public Discipline getDiscipline(int id) {return DisciplineDAO.getDiscipline(id);}

    @Override
    @Transactional
    public void deleteDiscipline(int id) {DisciplineDAO.deleteDiscipline(id);}
}
