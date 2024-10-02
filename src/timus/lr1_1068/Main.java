package timus.lr1_1068;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.close();
        int sum = 0;
        if(num >= 1) {
            for (int i = 1; i <= num; i++) {
                sum += i;
            }
        } else {
            for (int i = 1; i >= num; i--) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
