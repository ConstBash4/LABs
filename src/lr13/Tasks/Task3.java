package lr13.Tasks;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите размер массива:");
            int n = Integer.parseInt(scanner.nextLine());
            //Если введено отрицательное число
            if (n <= 0) {
                throw new IllegalArgumentException();
            }

            byte[] array = new byte[n];
            int sum = 0;

            System.out.println("Введите элементы массива:");
            for (int i = 0; i < n; i++) {
                try {
                    int num = Integer.parseInt(scanner.nextLine());

                    if (num < -128 || num > 127) {
                        throw new IllegalArgumentException();
                    }
                    array[i] = (byte) num;
                    sum += array[i];
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: Введено не число.");
                    i--; //Уменьшаем счетчик для повторного ввода
                } catch (IllegalArgumentException e) {
                    System.out.println("Ошибка: Значение выходит за пределы допустимого диапазона для типа byte. " +
                            "Введите целое число от -128 до 127.");
                    i--; //Уменьшаем счетчик для повторного ввода
                }
            }

            System.out.println("Сумма элементов массива: " + sum);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Введено не число.");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: Размер массива должен быть положительным числом.");
        } finally {
            System.out.println("Программа завершена.");
        }
    }
}
