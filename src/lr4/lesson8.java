package lr4;

import java.util.Scanner;

public class lesson8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите текст для шифрования:");
        String text = scanner.nextLine();
        System.out.print("Введите ключ:");
        int key = scanner.nextInt();
        String encText = EncodeText(text,key);
        String decText = EncodeText(encText,key*(-1));
        System.out.printf("Текст после преобразования: %s\n", encText);
        System.out.println("Выполнить обратное преобразование? (y/n)");
        boolean incorrect = false;
        scanner.nextLine();
        do {
            String answer = scanner.nextLine();
            switch (answer) {
                case "y": {
                    System.out.print("Обратное преобразование текста: " + decText);
                    scanner.close();
                    return;
                }
                case "n": {
                    System.out.print("До свидания!");
                    scanner.close();
                    return;
                }
                default: {
                    System.out.println("Введите корректный ответ!");
                    incorrect = true;
                    break;
                }
            }
        } while (incorrect);
    }

    private static String EncodeText(String text, int key) {
        char[] array = text.toCharArray();
        for (int i = 0; i < array.length; i++) {
            array[i] = (char)(array[i] + key);
        }
        return new String(array);
    }
}
