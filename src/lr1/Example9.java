package lr1;

import java.util.Scanner;

public class Example9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the name of the month:");
        String month = scanner.nextLine();

        System.out.println("Input the number of days in the month:");
        int day_number = scanner.nextInt();
        scanner.close();

        System.out.println("the month "+ month + " contains " + day_number + " days");
    }
}
