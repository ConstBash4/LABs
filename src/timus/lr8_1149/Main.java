package timus.lr8_1149;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        for (int i = 0; i < n-1; i++) {
            System.out.print("(");
        }

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i + 1; j++) {
                if(j > 0) {
                    if (j % 2 == 0) {
                        System.out.print("+");
                    } else {
                        System.out.print("-");
                    }
                }
                System.out.print("sin(" + (j + 1));
            }

            for (int j = 0; j < i + 1; j++) {
                System.out.print(")");
            }

            System.out.print("+" + (n-i));

            if(i != n - 1) {
                System.out.print(")");
            }
        }
    }
}
