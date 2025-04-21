package timus;

import java.util.Scanner;

public class tm2_1573 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] array = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        int numbers = scanner.nextInt();
        int count = 1;
        for (int i = 0; i < numbers; i++) {
            String s = scanner.next();
            switch (s) {
                case "Blue":
                    count *= array[0];
                    break;
                case "Red":
                    count *= array[1];
                    break;
                case "Yellow":
                    count *= array[2];
                    break;
            }
        }

        System.out.println(count);
        scanner.close();
    }
}
