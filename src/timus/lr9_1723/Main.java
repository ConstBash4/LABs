package timus.lr9_1723;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        Map<String, Integer> substringCountMap = countSubstrings(str);
        String mostFrequentSubstring = findMostFrequentSubstring(substringCountMap);
        System.out.println(mostFrequentSubstring);
    }

    public static Map<String, Integer> countSubstrings(String str) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String substring = str.substring(i, j);
                map.put(substring, map.getOrDefault(substring, 0) + 1);
            }
        }

        return map;
    }

    public static String findMostFrequentSubstring(Map<String, Integer> map) {
        String mostFrequentSubstring = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount ||
                    (entry.getValue() == maxCount && entry.getKey().length() > mostFrequentSubstring.length())) {
                mostFrequentSubstring = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return mostFrequentSubstring;
    }
}
