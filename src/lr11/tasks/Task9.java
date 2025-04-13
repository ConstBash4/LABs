package lr11.tasks;

import java.util.List;
import java.util.stream.Collectors;

public class Task9 {
    public static void main(String[] args) {
        String baseString = "Напишите1 функцию, которая2 принимает3 на4 вход5 " +
                "список6 строк7 и8 возвращает новый список, содержащий только " +
                "те строки, которые содержат только буквы (без цифр и символов).";
        int minLength = 8;
        System.out.println("Базовая строка: " + baseString);

        List<String> strings = List.of(baseString.split(" "));

        List<String> newStrings = LetterStr(strings, minLength);
        System.out.printf("Список строк с длиной больше %d:\n", minLength);
        for (String e : newStrings) {
            System.out.println(e);
        }
    }

    private static List<String> LetterStr(List<String> strList, int minLength) {
        return strList.stream()
                .filter(s -> s.chars().allMatch(Character::isLetter)) //если символ относится к букве
                .collect(Collectors.toList());
    }
}
