package timus;

import java.util.Arrays;
import java.util.Scanner;

public class tm_2111 {
    public static void main(String[] args) {
        long tax = 0;
        long initialWeight = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] d = new long[n];
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
            initialWeight += d[i];
        }
        sc.close();
        Arrays.sort(d);
        long item;
        long forward;
        long back;
        for (int i = d.length-1; i >= 0; i--) {
            item = d[i];
            forward = initialWeight * item;
            back = (initialWeight - item) * item;
            initialWeight -= item;
            tax += forward + back;
        }

        System.out.print(tax);
    }
}