package timus.lr13_1100;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        // Читаем количество команд
        int n = Integer.parseInt(br.readLine());

        // Создаем карту для хранения количества решенных задач и соответствующих команд
        Map<Integer, List<String>> resultMap = new TreeMap<>(Comparator.reverseOrder());

        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().split("\\s+");
            int solvedProblems = Integer.parseInt(parts[1]);
            String teamName = parts[0];

            // Добавляем команду в соответствующий список
            resultMap.computeIfAbsent(solvedProblems, k -> new ArrayList<>()).add(teamName);
        }

        // Выводим результаты
        for (Map.Entry<Integer, List<String>> entry : resultMap.entrySet()) {
            int solvedProblems = entry.getKey();
            List<String> teams = entry.getValue();

            // Сортируем команды по имени
            Collections.sort(teams);

            for (String team : teams) {
                pw.println(team + " " + solvedProblems);
            }
        }

        br.close();
        pw.close();
    }
}
/*
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer,Integer> numbers;
        for (int i = 0; i < n; i++) {

        }
        scanner.close();
    }
}
*/