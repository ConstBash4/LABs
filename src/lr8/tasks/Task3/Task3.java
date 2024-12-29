package lr8.tasks.Task3;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;

public class Task3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            // Создание потоков
            br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("E:\\MyFile1.txt"), StandardCharsets.UTF_8));

            bw = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream("E:\\MyFile2.txt"), StandardCharsets.UTF_8));

            // Переписывание информации из одного файла в другой
            int lineCount = 0;
            int wordCount = 0;
            String s;
            LinkedList<String> rightWords = new LinkedList<>();
            while ((s = br.readLine()) != null) {
                lineCount++;
                wordCount = 0;
                String[] words = s.split(" ");
                for (String word : words) {
                    if(consonantFirstChar(word)) {
                        rightWords.add(word);
                        wordCount++;
                    }
                }

                if(wordCount > 0) {
                    String output = "Строка: " + lineCount + "; Кол-во слов: " + wordCount + "; " + String.join(" ", rightWords);
                    System.out.println(output);
                    bw.write(output);
                    bw.newLine();
                }
                rightWords.clear();
            }
        } catch (IOException e) {
            System.out.println("Ошибка:" + e);
        } finally {
            br.close();
            bw.flush();
            bw.close();
        }
    }

    private static boolean consonantFirstChar(String word) {
        if(word == null || word.isEmpty()) { //isEmpty возвращает true, если word содержит пустую строку
            return false;
        }
        //Character.toLowerCase() преобразует символ(букву) в нижний регистр
        //charAt() возвращает символ из строки по переданному индексу
         char first = Character.toLowerCase(word.charAt(0));
         String consonants = "бвгджзклмнпрстфхцчшщ";
         int index = consonants.indexOf(first);
         return index != -1;
    }
}

