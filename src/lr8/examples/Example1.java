package lr8.examples;

import java.io.File;

public class Example1 {
    public static void main(String[] args) {
        try {
            // Создание файла в текущей папке (где расположен файл Example1.java)
            File f1 = new File("MyFile1.txt");
            f1.createNewFile();

            if (f1.exists()) {
                System.out.println("Создан!!!!");
                System.out.println("Полный путь1:	" + f1.getAbsolutePath());
            }

            // Создание файла на диске Е и вывод полного пути
            File f2=new File("E:\\MyFile2.txt");
            f2.createNewFile();
            System.out.println("Полный путь 2:	" + f2.getAbsolutePath());

            // Создание нескольких вложенных папок
            File f3 = new File("E:\\Papka1\\Papka2\\Papka3");
            f3.mkdirs();
            System.out.println("Полный путь 3:	" + f3.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Ошибка!!! " + e);
        }
    }
}
