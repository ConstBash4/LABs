package ru.vasilkov.Service1.service;

import org.springframework.stereotype.Service;
import ru.vasilkov.Service1.model.Positions;

@Service
public interface AnnualBonusService {
    double calculate(Positions positions, double salary, double bonus, int workDays);
}
