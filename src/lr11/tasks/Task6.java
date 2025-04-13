package lr11.tasks;

import java.util.*;
import java.util.stream.Collectors;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integers = new ArrayList<>(10);
        Random random = new Random();

        System.out.println("Заданный список:");
        for (int i = 0; i < 10; i++) {
            integers.add(random.nextInt(100));
            System.out.println(integers.get(i));
        }
        System.out.print("Введите делитель:");
        int divisor = scanner.nextInt();
        scanner.close();

        List<Integer> integersAfter = filterDividedNumbers(integers, divisor);

        System.out.printf("Числа которые делятся на %d без остатка:\n", divisor);

        for (Integer i : integersAfter) {
            System.out.println(i);
        }
    }

    public static List<Integer> filterDividedNumbers(List<Integer> list, int divisor) {
        return list.stream()
                .filter(x -> x % divisor == 0)
                .collect(Collectors.toList());
    }
}
