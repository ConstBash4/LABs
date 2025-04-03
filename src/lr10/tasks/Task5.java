package lr10.tasks;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean success = false;
        // Путь к файлу Excel
        //String filePath = "./src/lr10/tasks/example.xlsx";

        FileInputStream inputStream = null;
        XSSFWorkbook workbook = null;
        File file;

        while (!success) {
            try {
                System.out.println("Введите путь к Excel файлу:");
                String filePath = scanner.nextLine();
                // Проверка существования файла
                file = new File(filePath);
                if (!file.exists()) {
                    throw new FileNotFoundException("Файл не существует: " + filePath);
                }

                // Проверка расширения файла
                if (!file.getName().toLowerCase().endsWith(".xlsx")) {
                    throw new FileNotFoundException("Файл должен быть в формате .xlsx");
                }

                // Открываем файл Excel для чтения
                inputStream = new FileInputStream(file);

                // Создаем экземпляр книги Excel из файла
                workbook = new XSSFWorkbook(inputStream);

                // Получаем лист из книги по его имени
                XSSFSheet sheet = workbook.getSheet("Товары");
                if (sheet == null) {
                    throw new IllegalArgumentException("Лист 'Товары' не найден в книге.");
                }

                // Перебираем строки и ячейки листа
                for (Row row : sheet) {
                    for (Cell cell : row) {
                        // Выводим значение ячейки на экран
                        System.out.print(cell.toString() + "\t");
                    }
                    System.out.println();
                }

            } catch (FileNotFoundException e) {
                System.err.println(e.getMessage());
                System.out.println("Создайте файл формата xlsx");
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
                System.out.println("Создайте лист 'Товары' в книге");
            } catch (IOException e) {
                System.err.println("Произошла ошибка при чтении файла: " + e.getMessage());
                System.out.println("Возможно файл поврежден");
            } finally {
                try {
                    if (workbook != null) workbook.close();
                    if (inputStream != null) inputStream.close();
                } catch (IOException e) {
                    System.err.println("Ошибка при закрытии файла: " + e.getMessage());
                }
                System.out.println("Попробовать снова? (да/нет)");
                String retry = scanner.nextLine().toLowerCase();
                success = !retry.equals("да");
            }
        }
        // Закрываем файл и освобождаем ресурсы
        try {
            if (workbook != null) workbook.close();
            if (inputStream != null) inputStream.close();
        } catch (IOException e) {
            System.err.println("Ошибка при закрытии файла: " + e.getMessage());
        }
        scanner.close();
    }
}