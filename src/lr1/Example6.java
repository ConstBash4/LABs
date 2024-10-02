package lr1;

import java.util.Scanner;

public class Example6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input the second name:");
        String second_name = scanner.nextLine();

        System.out.println("Input the first name:");
        String first_name = scanner.nextLine();

        System.out.println("Input the patronymic:");
        String patronymic = scanner.nextLine();

        System.out.println("Hello, " + second_name + " " + first_name + " " + patronymic + "!");
        scanner.close();
    }
}
