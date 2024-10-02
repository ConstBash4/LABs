package lr1;

import java.util.Scanner;

public class Example7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input the first name:");
        String first_name = scanner.nextLine();

        System.out.println("Input the age:");
        int age = scanner.nextInt();

        System.out.println("Your name is " + first_name);
        System.out.println("Your age is " + age);
        scanner.close();
    }
}
