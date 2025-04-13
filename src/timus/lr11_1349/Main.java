package timus.lr11_1349;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        switch (n) {
            case 1: {
                System.out.println("1 2 3");
                break;
            }
            case 2: {
                System.out.println("3 4 5");
                break;
            }
            default: {
                System.out.println("-1");
                break;
            }
        }
    }
}
