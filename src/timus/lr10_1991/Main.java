package timus.lr10_1991;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        long droids = 0;
        long booms = 0;

        int a;
        for (int i = 0; i < n; i++) {
            a = scanner.nextInt();
            if (a <= k) {
                droids += (k - a);
            } else {
                booms += (a - k);
            }
        }

        System.out.println(booms + " " + droids);
        scanner.close();
    }
}
