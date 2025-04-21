package timus;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class tm2_1290 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> array = new ArrayList<>();
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            array.add(scanner.nextInt());
        }
        array.sort(Collections.reverseOrder());
        for (int num : array) {
            System.out.println(num);
        }
        scanner.close();
    }
}
