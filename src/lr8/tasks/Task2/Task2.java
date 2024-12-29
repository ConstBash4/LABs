package lr8.tasks.Task2;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Task2 {
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
            String s;
            while ((s = br.readLine()) != null) {
                lineCount++;
                if (lineCount >= 3) {
                    try {
                        double value = Double.parseDouble(s); //парсим double из файла
                        if (value > 0) {
                            bw.write(Double.toString(value)); //преобразуем double в String для записи в файл
                            bw.newLine(); //перевод строки
                            System.out.println(lineCount + ":" + value);
                        }
                    } catch (NumberFormatException numEx) {
                        System.out.println("Ошибка при парсинге числа");
                    }
                } else if (lineCount == 2) {
                    bw.write(s);
                    bw.newLine();
                    System.out.println(lineCount + ":" + s);
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка:" + e);
        } finally {
            br.close();
            bw.flush();
            bw.close();
        }
    }
}

