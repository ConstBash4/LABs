package lr13.Tasks;

import java.util.Random;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Random random = new Random();
            System.out.print("Введите количество строк (m):");
            int m = Integer.parseInt(scanner.nextLine());

            System.out.print("Введите количество столбцов (n):");
            int n = Integer.parseInt(scanner.nextLine());
            //Если введено отрицательное число
            if (m <= 0 || n <= 0) {
                throw new IllegalArgumentException();
            }

            int[][] matrix = new int[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = random.nextInt(9) + 1;
                }
            }
            System.out.println("Сгенерированная матрица:");
            System.out.print("   ");
            for (int j = 1; j <= n; j++) {
                System.out.printf("%4d", j); //Номера столбцов
            }
            System.out.println();
            //Число в спецификаторе формата - ширина поля вывода
            for (int i = 0; i < m; i++) {
                System.out.printf("%2d:", i + 1); //Номера строк
                for (int j = 0; j < n; j++) {
                    System.out.printf("%4d", matrix[i][j]);
                }
                System.out.println();
            }

            System.out.print("Введите номер столбца для вывода:");
            int columnNumber = Integer.parseInt(scanner.nextLine());

            if (columnNumber < 1 || columnNumber > n) {
                throw new ArrayIndexOutOfBoundsException();
            }

            System.out.println("Столбец #" + columnNumber + ":");
            for (int i = 0; i < m; i++) {
                System.out.println(matrix[i][columnNumber - 1]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Введено не число. Введите целое число.");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: Размеры матрицы должны быть положительными числами.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: Нет столбца с таким номером.");
        } finally {
            System.out.println("Программа завершена.");
        }
    }
}
