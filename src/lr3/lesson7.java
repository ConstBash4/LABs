package lr3;

import java.util.Scanner;

public class lesson7 {
    public static void main(String[] args) {
        System.out.print("Введите длину массива: ");
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        scanner.close();

        if (count <= 0 || count > 10) {
            System.out.print("Некорректное значение");
            return;
        }
        char[] alphabet = "acegikmoqs".toCharArray(); //конвертируем строку в массив символов
        MasOutput(ascMas(count, alphabet));
        MasOutput(descMas(count, alphabet));
    }

    private static char[] ascMas(int count, char[] alphabet) {
        char[] ascAlphabet = new char[count];
        for (int i = 0; i < count; i++) {
            ascAlphabet[i] = alphabet[i];
        }
        return ascAlphabet;
    }

    private static char[] descMas(int count, char[] alphabet) {
        char[] descAlphabet = new char[count];
        for (int i = 0; i < count; i++) {
            descAlphabet[descAlphabet.length-i-1] = alphabet[i];
        }
        return descAlphabet;
    }

    private static void MasOutput(char[] mas) {
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + " ");
        }
        System.out.print("\n");
    }
}
