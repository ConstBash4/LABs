package lr1;

import java.util.Scanner;

public class Example13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input first number:");
        int f_num = scanner.nextInt();

        System.out.println("Input second number:");
        int s_num = scanner.nextInt();
        scanner.close();

        System.out.println("The sum of two numbers is: " + (f_num+s_num));
    }
}
