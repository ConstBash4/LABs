package lr11.tasks;

import java.util.List;
import java.util.stream.Collectors;

public class Task5 {
    public static void main(String[] args) {
        String baseString = "Напишите функцию, которая принимает на вход список строк и " +
                "возвращает новый список, содержащий только те строки, " +
                "которые содержат заданную подстроку.";
        System.out.println("Базовая строка: " + baseString);
        String findSubStr = "строк";
        List<String> strings = List.of(baseString.split(" "));


        List<String> newStrings = subStr(strings, findSubStr);
        System.out.printf("Список строк с подстрокой \"%s\": \n", findSubStr);
        for (String e : newStrings) {
            System.out.println(e);
        }
    }

    private static List<String> subStr(List<String> strList, String subStr) {
        return strList.stream()
                .filter(s -> s.contains(subStr))
                .collect(Collectors.toList());
    }
}
