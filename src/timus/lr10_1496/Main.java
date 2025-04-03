package timus.lr10_1496;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> lineCounts = new HashMap<>();

        int numberOfLines = scanner.nextInt();

        scanner.nextLine();

        for (int i = 0; i < numberOfLines; i++) {
            String inputLine = scanner.nextLine();
            lineCounts.put(inputLine, lineCounts.getOrDefault(inputLine, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : lineCounts.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey());
            }
        }

        scanner.close();
    }
}
