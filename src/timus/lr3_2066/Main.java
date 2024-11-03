package timus.lr3_2066;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[3];
        Scanner scanner = new Scanner(System.in);
        nums[0] = scanner.nextInt();
        nums[1] = scanner.nextInt();
        nums[2] = scanner.nextInt();
        scanner.close();

        int[] answers = new int[3];
        answers[0] = nums[0] - nums[1] - nums[2];
        answers[1] = nums[0] - nums[1] * nums[2];
        answers[2] = nums[0] * nums[1] - nums[2];
        int min = answers[0];
        for (int i = 0; i < 3; i++) {
            if (min > answers[i]) min = answers[i];
        }
        System.out.print(min);
    }
}
