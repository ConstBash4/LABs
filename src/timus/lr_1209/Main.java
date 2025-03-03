package timus.lr_1209;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextLong();
        }
        scanner.close();
        for (long item : array) {
            long t = (item-1) * 8 + 1;
            if (Math.pow((int)Math.sqrt(t), 2) == t) {
                System.out.print("1 ");
            } else {
                System.out.print("0 ");
            }
        }
    }
}
