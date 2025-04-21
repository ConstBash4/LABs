package timus.lr13_2023;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int steps = 0;
        int position = 0;
        String name;
        String[][] shelves = {
                {"A", "P", "O", "R"},
                {"B", "M", "S"},
                {"D", "G", "J", "K", "T", "W"}
        };
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            name = scanner.nextLine();
            for (int j = 0; j < shelves.length; j++) {
                boolean founded = false;
                for (int k = 0; k < shelves[j].length; k++) {
                    if (shelves[j][k].charAt(0) == name.charAt(0)) {
                        steps += Math.abs(j - position);
                        position = j;
                        founded = true;
                        break;
                    }
                }
                if (founded) {
                    break;
                }
            }
        }
        System.out.print(steps);
        scanner.close();
    }
}
