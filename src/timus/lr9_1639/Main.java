package timus.lr9_1639;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.close();
        if (m * n % 2 == 0) {
            System.out.print("[:=[first]");
        } else {
            System.out.print("[second]=:]");
        }
    }
}
