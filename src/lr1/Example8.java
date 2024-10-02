package lr1;

import java.util.Scanner;

public class Example8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input the day of the week:");
        String day_week = scanner.nextLine();

        System.out.println("Input the name of the month:");
        String month = scanner.nextLine();

        System.out.println("Input the day number in the month:");
        int day_number = scanner.nextInt();

        System.out.println("Today is " + day_week + " day of week, " + day_number + " of " + month);
        scanner.close();
    }
}
