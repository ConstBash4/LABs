package lr1;

import java.util.Scanner;

public class Example14 {
    public static void main(String[] args) {
        final int arraySize = 4;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input number:");
        int[] nums = new int[arraySize];
        nums[1] = scanner.nextInt();
        scanner.close();

        System.out.println("num-1 is: " + (nums[0]=nums[1]-1));
        System.out.println("num is: " + nums[1]);
        System.out.println("num+1 is: " + (nums[2]=nums[1]+1));
        nums[3] = 0;
        for(int i = 0; i < arraySize-1; i++) {
            nums[3] += nums[i];
        }
        nums[3] = nums[3]*nums[3];
        System.out.println("(num1+num2+num3)^2 is: " + nums[3]);
    }
}
