package lr11.tasks;

import java.util.List;
import java.util.stream.Collectors;

public class Task7 {
    public static void main(String[] args) {
        String baseString = "Напишите функцию, которая принимает на вход " +
                "список строк и возвращает новый список, содержащий только " +
                "те строки, которые имеют длину больше заданного значения.";
        int minLength = 8;
        System.out.println("Базовая строка: " + baseString);

        List<String> strings = List.of(baseString.split(" "));

        List<String> newStrings = minLengthStr(strings, minLength);
        System.out.printf("Список строк с длиной больше %d:\n", minLength);
        for (String e : newStrings) {
            System.out.println(e);
        }
    }

    private static List<String> minLengthStr(List<String> strList, int minLength) {
        return strList.stream()
                .filter(s -> s.length() > minLength)
                .collect(Collectors.toList());
    }
}
