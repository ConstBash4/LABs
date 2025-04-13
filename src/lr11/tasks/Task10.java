package lr11.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integers = new ArrayList<>(10);
        Random random = new Random();

        System.out.println("Заданный список:");
        for (int i = 0; i < 10; i++) {
            integers.add(random.nextInt(100));
            System.out.println(integers.get(i));
        }
        System.out.print("Введите число для сравнения:");
        int min = scanner.nextInt();
        scanner.close();

        List<Integer> integersAfter = filterMoreThanNumbers(integers, min);

        System.out.printf("Числа меньше, чем %d:\n", min);

        for (Integer i : integersAfter) {
            System.out.println(i);
        }
    }

    public static List<Integer> filterMoreThanNumbers(List<Integer> list, int min) {
        return list.stream()
                .filter(x -> x < min)
                .collect(Collectors.toList());
    }
}
