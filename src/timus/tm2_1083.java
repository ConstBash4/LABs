package timus;

import java.util.Scanner;

public class tm2_1083 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int num = Integer.parseInt(input[0]);
        int digit = input[1].length();

        int value = 1;
        int last = 1;

        if (num % digit != 0) {
            last = num % digit;
        }

        while (num != num % digit) {
            value *= num;
            num -= digit;
        }

        System.out.println(value * last);
        scanner.close();
    }
}
