package lr9.tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Task6 {

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        fillMap(map);

        System.out.println("Исходная MAP:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        System.out.println("Строки с ключом больше 5:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() > 5) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        }

        System.out.println("Строки с ключом равным 0:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() == 0) {
                System.out.println("0:" + entry.getValue());
            }
        }

        int keys = 1;
        boolean hasLongStrings = false;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().length() > 5) {
                keys *= entry.getKey();
                hasLongStrings = true;
            }
        }

        System.out.println("Произведение ключей, где длина строки больше 5:");
        if (hasLongStrings) {
            System.out.println(keys);
        } else {
            System.out.println("Нет строк с длиной больше 5 символов.");
        }
    }

    private static void fillMap(Map<Integer, String> map) {
        Random rnd = new Random();
        for (int i = 0; i < 10; i++) {
            map.put(i, generateRandString(rnd));
        }
    }

    private static String generateRandString(Random rnd) {
        int len = rnd.nextInt(10) + 1;
        char[] randChar = new char[len];
        for (int i = 0; i < len; i++) {
            randChar[i] = (char)(rnd.nextInt(26) + 65);
        }
        return new String(randChar);
    }
}
