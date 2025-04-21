package lr13.Tasks;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите размер массива:");
            int n = Integer.parseInt(scanner.nextLine());
            //Если введено отрицательное число
            if (n <= 0) {
                throw new IllegalArgumentException();
            }

            int[] array = new int[n];
            int sum = 0;
            int countPositiveNumbers = 0;

            System.out.println("Введите элементы массива:");
            for (int i = 0; i < n; i++) {
                try {
                    array[i] = Integer.parseInt(scanner.nextLine());

                    if (array[i] > 0) {
                        sum += array[i];
                        countPositiveNumbers++;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: Введено не число. Введите целое число.");
                    i--; //Уменьшаем счетчик для повторного ввода
                }
            }
            //Если положительных элементов нет
            if (countPositiveNumbers == 0) {
                throw new ArithmeticException();
            }

            double average = (double) sum / countPositiveNumbers;
            System.out.println("Среднее значение среди положительных элементов: " + average);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Введено не число. Введите целое число.");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: Размер массива должен быть положительным числом.");
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: Положительные элементы отсутствуют.");
        } finally {
            System.out.println("Программа завершена.");
        }
    }
}
