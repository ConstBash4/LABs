package timus.lr13_1319;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        int[][] matrix = new int[n][n];
        int number = 1;
        int column = n - 1;
        int row;
        int depth;

        while (column >= 0) {
            row = 0;
            depth = column;
            while (depth < n) {
                matrix[row][depth] = number;
                number++;
                depth++;
                row++;
            }
            column--;
        }
        row = 1;
        while (row < n) {
            column = 0;
            depth = row;
            while (depth < n) {
                matrix[depth][column] = number;
                number++;
                depth++;
                column++;
            }
            row++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
