package lr3;

import java.util.Scanner;

public class lesson5 {
    public static void main(String[] args) {
        System.out.print("Введите количество чисел в последовательности: ");
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        scanner.close();

        if (count <= 0) {
            System.out.print("Некорректное значение");
            return;
        }
        MasOutput(sumFor(count));
        MasOutput(sumWhile(count));
        MasOutput(sumDoWhile(count));
    }

    private static int[] sumFor(int count) {
        int[] nums = new int[count];
        int num = 0;
        for (int i = 0; i < count; i++) {
            num = getValue(num);
            nums[i] = num;
        }
        return nums;
    }

    private static int[] sumWhile(int count) {
        int[] nums = new int[count];
        int num = 0;
        int i = 0;
        while (i < count) {
            num = getValue(num);
            nums[i] = num;
            i++;
        }
        return nums;
    }

    private static int[] sumDoWhile(int count) {
        int[] nums = new int[count];
        int num = 0;
        int i = 0;
        do {
            num = getValue(num);
            nums[i] = num;
            i++;
        } while (i < count);
        return nums;
    }

    private static int getValue(int currentNum) {
        while (true) {
            currentNum++;
            if(currentNum % 5 == 2 || currentNum % 3 == 1) {
                return currentNum;
            }

        }
    }

    private static void MasOutput(int[] mas) {
        int sum = 0;
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + " ");
            sum += mas[i];
        }
        System.out.printf("sum: %d\n", sum);
    }
}
