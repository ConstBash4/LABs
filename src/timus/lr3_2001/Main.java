package timus.lr3_2001;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] a = new int[3];
        int[] b = new int[3];
        Scanner scanner = new Scanner(System.in);
        a[0] = scanner.nextInt();
        b[0] = scanner.nextInt();
        a[1] = scanner.nextInt();
        b[1] = scanner.nextInt();
        a[2] = scanner.nextInt();
        b[2] = scanner.nextInt();
        scanner.close();

        System.out.printf("%d %d", a[0]-a[2], b[0]-b[1]);
    }
}