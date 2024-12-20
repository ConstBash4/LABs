package timus.lr7_1636;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int t_qxx, t_zzz, penalty_tries = 0, time = 20;
        int[] tries = new int[10];
        Scanner scanner = new Scanner(System.in);
        t_qxx = scanner.nextInt();
        t_zzz = scanner.nextInt();
        for (int i = 0; i < tries.length; i++) {
            tries[i] = scanner.nextInt();
            penalty_tries += tries[i];
        }
        scanner.close();

        time *= penalty_tries;
        t_zzz -= time;

        if(t_zzz == t_qxx || t_zzz > t_qxx) {
            System.out.print("No chance.");
        } else {
            System.out.print("Dirty debug :(");
        }
    }
}
