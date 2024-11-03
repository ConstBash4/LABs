package lr3;

import java.util.Scanner;

public class lesson2 {
    public static void main(String[] args) {
        System.out.print("Введите день недели:");
        Scanner scanner = new Scanner(System.in);
        String day = scanner.nextLine();
        scanner.close();

        switch (day) {
            case "Понедельник": {
                System.out.println(1);
                break;
            }
            case "Вторник": {
                System.out.println(2);
                break;
            }
            case "Среда": {
                System.out.println(3);
                break;
            }
            case "Четверг": {
                System.out.println(4);
                break;
            }
            case "Пятница": {
                System.out.println(5);
                break;
            }
            case "Суббота": {
                System.out.println(6);
                break;
            }
            case "Воскресенье": {
                System.out.println(7);
                break;
            }
            default: {
                System.out.println("Такого дня нет");
                break;
            }
        }

        if(day.equals("Понедельник")) {
            System.out.println(1);
        } else if (day.equals("Вторник")) {
            System.out.println(2);
        } else if (day.equals("Среда")) {
            System.out.println(3);
        } else if (day.equals("Четверг")) {
            System.out.println(4);
        } else if (day.equals("Пятница")) {
            System.out.println(5);
        } else if (day.equals("Суббота")) {
            System.out.println(6);
        } else if (day.equals("Воскресенье")) {
            System.out.println(7);
        } else {
            System.out.println("Такого дня нет");
        }
    }
}
