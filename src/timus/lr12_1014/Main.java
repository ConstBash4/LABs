package timus.lr12_1014;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        StringBuilder result = new StringBuilder();

        if (number == 0) {
            System.out.println(10);
        } else if (number == 1) {
            System.out.println(number);
        } else {
            for (int i = 9; i >= 2; i--) {
                while (number % i == 0) {
                    result.append(i);
                    number /= i;
                }
            }
            if (number == 1) {
                System.out.println(result.reverse());
            } else {
                System.out.println(-1);
            }
        }
    }
}
