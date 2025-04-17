package timus.lr12_2100;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 2;
        String str;
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            str = scanner.nextLine();
            count += str.split("\\+").length;
        }

        if (count != 13) {
            System.out.println(count * 100);
        } else {
            System.out.println(count * 100 + 100);
        }
    }
}
