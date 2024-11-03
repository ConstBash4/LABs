package lr3;

import java.util.Scanner;

public class lesson4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите наименьшее число: ");
        int min = scanner.nextInt();
        System.out.print("Введите наибольшее число: ");
        int max = scanner.nextInt();
        scanner.close();

        if (min >= max) {
            System.out.print("Некорректные значения");
            return;
        }

        MasOutput(minMaxFor(min, max));
        MasOutput(minMaxWhile(min, max));
        MasOutput(minMaxDoWhile(min, max));
    }

    private static int[] minMaxFor(int min, int max) {
        int lenght = (max-min) + 1;
        int[] nums = new int[lenght];
        nums[0] = min;
        for (int i = 1; i < lenght; i++) {
            nums[i] = nums[i-1] + 1;
        }
        return nums;
    }

    private static int[] minMaxWhile(int min, int max) {
        int lenght = (max-min) + 1;
        int[] nums = new int[lenght];
        nums[0] = min;
        int i = 1;
        while (i < lenght) {
            nums[i] = nums[i-1] + 1;
            i++;
        }
        return nums;
    }

    private static int[] minMaxDoWhile(int min, int max) {
        int lenght = (max-min) + 1;
        int[] nums = new int[lenght];
        nums[0] = min;
        int i = 1;
        do {
            nums[i] = nums[i-1] + 1;
            i++;
        } while (i < lenght);
        return nums;
    }

    private static void MasOutput(int[] mas) {
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + " ");
        }
        System.out.print("\n");
    }
}
