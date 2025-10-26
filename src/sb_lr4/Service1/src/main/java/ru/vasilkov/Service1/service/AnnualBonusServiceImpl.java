package ru.vasilkov.Service1.service;

import org.springframework.stereotype.Service;
import ru.vasilkov.Service1.model.Positions;

import java.time.LocalDate;

@Service
public class AnnualBonusServiceImpl implements AnnualBonusService {
    @Override
    public double calculate(Positions positions, double salary, double bonus, int workDays) {
        int year = LocalDate.now().getYear();
        int daysInYear = isLeapYear(year) ? 366 : 365; // тернарная операция
        return salary * bonus * daysInYear * positions.getPositionCoefficient() / workDays;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public double calculateQuarterlyBonus(Positions positions, double salary, double bonus, int workDays) {
        if (!positions.isManager()) {
            throw new IllegalArgumentException("метод работает только для менеджеров");
        }

        return salary * bonus * 90 * positions.getPositionCoefficient() / workDays;
    }
}
