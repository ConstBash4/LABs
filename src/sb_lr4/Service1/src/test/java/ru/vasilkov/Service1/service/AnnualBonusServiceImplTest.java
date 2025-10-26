package ru.vasilkov.Service1.service;

import org.junit.jupiter.api.Test;
import ru.vasilkov.Service1.model.Positions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AnnualBonusServiceImplTest {

    @Test
    void calculate() {
        //given
        Positions position = Positions.HR;
        double bonus = 2.0;
        int workDays = 243;
        double salary = 100000.00;

        //when
        double result = new AnnualBonusServiceImpl().calculate(position, salary, bonus, workDays);

        //then
        double expected = 360493.8271604938;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void testCalculateQuarterlyBonus() {
        //TEST CASE 1: MANAGER
        //given
        Positions position = Positions.MANAGER;
        double salary = 100000.0;
        double bonus = 0.2;
        int workDays = 220;

        //when
        double result = new AnnualBonusServiceImpl().calculateQuarterlyBonus(position, salary, bonus, workDays);

        //then
        double expected = (100000.0 * 0.2 * 90 * 3.0) / 220;
        assertThat(result).isEqualTo(expected);

        //TEST CASE 2: NON MANAGER
        //Проверка, что исключение выбрасывается
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new AnnualBonusServiceImpl().calculateQuarterlyBonus(Positions.HR, salary, bonus, workDays));
        assertThat(exception.getMessage()).isEqualTo("метод работает только для менеджеров");
    }
}