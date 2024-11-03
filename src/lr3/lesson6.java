package lr3;

import java.util.Scanner;

public class lesson6 {
    public static void main(String[] args) {
        System.out.print("Введите длину массива: ");
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        scanner.close();

        if (count <= 0) {
            System.out.print("Некорректное значение");
            return;
        }
        MasOutput(masFor(count));
    }

    private static int[] masFor(int count) {
        int[] nums = new int[count];
        for (int i = 0; i < count; i++) {
            nums[i] = (5 * i) + 2;
        }
        return nums;
    }

    private static void MasOutput(int[] mas) {
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + " ");
        }
        System.out.print("\n");
    }
}
