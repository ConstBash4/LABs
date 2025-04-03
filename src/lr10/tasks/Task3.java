package lr10.tasks;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class Task3 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String path = "./src/lr10/tasks/task3.json";
        actions(path);
    }

    private static void actions(String path) {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("1 - вывести весь список товаров");
            System.out.println("2 - поиск товара по названию");
            System.out.println("3 - добавить новый товар");
            System.out.println("4 - удалить товар");
            System.out.println("5 - выход");

            int number = scanner.nextInt();

            switch (number) {
                case 1:
                    listData(path);
                    break;
                case 2:
                    findPart(path);
                    break;
                case 3:
                    addPart(path);
                    break;
                case 4:
                    deletePart(path);
                    break;
                case 5:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Неверный ввод. Пожалуйста, введите число от 1 до 5.");
                    break;
            }
        }

        scanner.close();
    }

    private static void listData(String path) {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(path));
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println("Корневой элемент: " + jsonObject.keySet().iterator().next());
            JSONArray jsonArray = (JSONArray) jsonObject.get("computer_parts");

            for (Object o : jsonArray) {
                JSONObject parts = (JSONObject) o;
                System.out.println("Название: " + parts.get("name"));
                System.out.println("Категория: " + parts.get("category"));
                System.out.println("Описание: " + parts.get("description"));
                System.out.println("Цена: " + parts.get("price"));
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void findPart(String path) {
        System.out.println("Введите название товара: ");
        scanner.nextLine();
        String name = scanner.nextLine();

        List<JSONObject> parts = new ArrayList<>(0);
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(path));
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println("Корневой элемент: " + jsonObject.keySet().iterator().next());
            JSONArray jsonArray = (JSONArray) jsonObject.get("computer_parts");

            parts = jsonArray.stream()
                    .map(part -> (JSONObject) part)
                    .filter(part -> name.equals(((JSONObject)part).get("name")))
                    .toList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (parts.isEmpty()) {
            System.out.println("Товар не найден");
        } else {
            for(JSONObject part : parts) {
                System.out.println("\nPart:");
                System.out.println("Название: " + part.get("name"));
                System.out.println("Категория: " + part.get("category"));
                System.out.println("Описание: " + part.get("description"));
                System.out.println("Цена: " + part.get("price"));
            }
        }
    }

    private static void addPart(String path) {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(path));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray) jsonObject.get("computer_parts");

            scanner.nextLine();
            System.out.print("Введите название: ");
            String name = scanner.nextLine();
            System.out.print("Введите категорию: ");
            String category = scanner.nextLine();
            System.out.print("Введите описание: ");
            String description = scanner.nextLine();
            System.out.print("Введите цену: ");
            Double price = scanner.nextDouble();

            JSONObject computerParts = new JSONObject();
            JSONObject newPart = new JSONObject();
            newPart.put("name", name);
            newPart.put("category", category);
            newPart.put("description", description);
            newPart.put("price", price.toString());

            jsonArray.add(newPart);
            computerParts.put("computer_parts", jsonArray);

            try (FileWriter file = new FileWriter(path)) {
                file.write(computerParts.toJSONString());
                System.out.println("JSON файл успешно обновлен!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void deletePart(String path) {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(path));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray) jsonObject.get("computer_parts");

            System.out.print("Введите название: ");
            scanner.nextLine();
            String name = scanner.nextLine();

            Iterator iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                JSONObject part = (JSONObject) iterator.next();
                if(name.equals(part.get("name"))) {
                    iterator.remove();
                }
            }

            try (FileWriter file = new FileWriter(path)) {
                file.write(jsonObject.toJSONString());
                System.out.println("JSON файл успешно обновлен!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
