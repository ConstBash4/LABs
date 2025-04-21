package timus;

import java.util.Scanner;

public class tm2_1787 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int howMuch = scanner.nextInt();
        int minutes = scanner.nextInt();
        int[] array = new int[minutes];

        for (int i = 0; i < minutes; i++) {
            array[i] = scanner.nextInt();
        }
        int carsCount = 0;
        for (int carsNow : array) {
            if (carsNow <= howMuch) {
                carsCount -= (howMuch - carsNow);
                if (carsCount < 0) {
                    carsCount = 0;
                }
            } else {
                carsCount += (carsNow - howMuch);
            }
        }

        System.out.println(carsCount);
        scanner.close();
    }
}
