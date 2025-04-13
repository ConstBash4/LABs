package lr11.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task8 {
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
        int max = scanner.nextInt();
        scanner.close();

        List<Integer> integersAfter = filterMoreThanNumbers(integers, max);

        System.out.printf("Числа больше, чем %d:\n", max);

        for (Integer i : integersAfter) {
            System.out.println(i);
        }
    }

    public static List<Integer> filterMoreThanNumbers(List<Integer> list, int max) {
        return list.stream()
                .filter(x -> x > max)
                .collect(Collectors.toList());
    }
}
