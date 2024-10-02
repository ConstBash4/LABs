package lr1;

import java.util.Scanner;

public class Example15 {
    public static void main(String[] args) {
        final int arraySize = 2;
        int[] nums = new int[arraySize];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input first number:");
        nums[0] = scanner.nextInt();
        System.out.println("Input second number:");
        nums[1] = scanner.nextInt();
        scanner.close();

        System.out.println("num1+num2 is: " + (nums[0]+nums[1]));
        System.out.println("num1-num2 is: " + (nums[0]-nums[1]));
    }
}
