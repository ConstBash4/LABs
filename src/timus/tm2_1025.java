package timus;

import java.util.Arrays;
import java.util.Scanner;

public class tm2_1025 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] array = new int[number];

        for (int i = 0; i < number; i++) {
            array[i] = scanner.nextInt();
        }
        Arrays.sort(array);
        int count = 0;
        for (int i = 0; i <= number / 2; i++) {
            count += (array[i] / 2) + 1;
        }

        System.out.println(count);
        scanner.close();
    }
}
