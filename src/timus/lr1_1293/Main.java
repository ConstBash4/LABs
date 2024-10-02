package timus.lr1_1293;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[3];
        nums[0] = scanner.nextInt();
        nums[1] = scanner.nextInt();
        nums[2] = scanner.nextInt();
        scanner.close();

        System.out.println(nums[0]*(2*(nums[1]*nums[2])));
    }
}

