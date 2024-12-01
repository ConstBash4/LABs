package timus.lr5_2056;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n;
        int[] m;
        int sum = 0;
        boolean excellent = true;

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = new int[n];
        for (int i = 0; i < n; i++) {
            m[i] = scanner.nextInt();
        }
        scanner.close();

        for(int num : m) {
            if (num == 3) {
                System.out.print("None");
                return;
            } else if (num == 4) {
                excellent = false;
            }
            sum += num;
        }

        if(excellent) {
            System.out.print("Named");
        } else if((sum/(double)n) >= 4.5) {
            System.out.print("High");
        } else {
            System.out.print("Common");
        }
    }
}
