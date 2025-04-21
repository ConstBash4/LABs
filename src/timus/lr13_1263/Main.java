package timus.lr13_1263;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int index;
        int[] votes = new int[n];
        for (int i = 0; i < m; i++) {
            index = scanner.nextInt();
            votes[index-1] += 1;
        }
        for (int vote : votes) {
            System.out.printf("%.2f%%\n", (((double)vote * 100) / (double)m));
        }
        scanner.close();
    }
}
