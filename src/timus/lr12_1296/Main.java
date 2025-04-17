package timus.lr12_1296;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        int max = 0;
        int input;
        for(int i = 0; i < n; i++) {
            input = scanner.nextInt();
            sum += input;
            if(sum < 0) sum = 0;
            max = Math.max(sum, max);
        }
        System.out.print(max);
        scanner.close();
    }
}
