package lr3;

import java.util.Scanner;

public class lesson3 {
    public static void main(String[] args) {
        System.out.print("Введите количество чисел в последовательности: ");
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        scanner.close();

        if (count <= 0) {
            System.out.print("Некорректное значение");
            return;
        } else if (count == 1) {
            System.out.print("0");
            return;
        }
        MasOutput(FibFor(count));
        MasOutput(FibWhile(count));
        MasOutput(FibDoWhile(count));
    }
    // count >= 2
    private static int[] FibFor(int count) {
        int[] nums = new int[count];
        nums[0] = 0;
        nums[1] = 1;
        for (int i = 2; i < count; i++) {
            nums[i] = nums[i-1] + nums[i-2];
        }
        return nums;
    }

    private static int[] FibWhile(int count) {
        int[] nums = new int[count];
        nums[0] = 0;
        nums[1] = 1;
        int i = 2;
        while (i < count) {
            nums[i] = nums[i-1] + nums[i-2];
            i++;
        }
        return nums;
    }

    private static int[] FibDoWhile(int count) {
        int[] nums = new int[count];
        nums[0] = 0;
        nums[1] = 1;
        int i = 2;
        if (i == count) return nums;
        do {
            nums[i] = nums[i-1] + nums[i-2];
            i++;
        } while (i < count);
        return nums;
    }

    private static void MasOutput(int[] mas) {
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + " ");
        }
        System.out.print("\n");
    }
}
