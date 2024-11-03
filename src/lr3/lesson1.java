package lr3;

import java.util.Scanner;

public class lesson1 {
    public static void main(String[] args) {
        System.out.print("Введите число:");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.close();

        switch (num) {
            case 1: {
                System.out.println("Понедельник");
                break;
            }
            case 2: {
                System.out.println("Вторник");
                break;
            }
            case 3: {
                System.out.println("Среда");
                break;
            }
            case 4: {
                System.out.println("Четверг");
                break;
            }
            case 5: {
                System.out.println("Пятница");
                break;
            }
            case 6: {
                System.out.println("Суббота");
                break;
            }
            case 7: {
                System.out.println("Воскресенье");
                break;
            }
            default: {
                System.out.println("Некорректное значение");
                break;
            }
        }
    }
}
