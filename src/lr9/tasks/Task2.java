package lr9.tasks;

import java.util.Scanner;

public class Task2 {

    public static String toBinary(int number) {
        if (number == 0 || number == 1) {
            return Integer.toString(number);
        } else {
            return toBinary(number / 2) + (number % 2);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.close();

        if (number < 0) System.out.println("Число должно быть неотрицательным.");
        else {
            String binary = toBinary(number);
            System.out.println("Двоичное представление числа " + number + ": " + binary);
        }
    }
}
