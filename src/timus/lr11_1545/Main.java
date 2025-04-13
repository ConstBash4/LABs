package timus.lr11_1545;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<String> strings = new LinkedList<String>();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            strings.add(scanner.nextLine());
        }
        char ch = scanner.next().charAt(0);
        scanner.close();
        List<String> filteredStrings = strings.stream()
                .filter(s -> s.charAt(0) == ch)
                .collect(Collectors.toList());
        if (!filteredStrings.isEmpty()) {
            for (String s : filteredStrings) {
                System.out.println(s);
            }
        }
    }
}
