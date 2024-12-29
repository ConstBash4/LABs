package timus.lr8_1224;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        sc.close();
        if(n <= m) {
            System.out.print(2 * n - 2);
        } else {
            System.out.print(2 * m - 1);
        }
    }
}
