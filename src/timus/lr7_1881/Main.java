package timus.lr7_1881;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String str = "";
        int h,w,n;
        double pages;
        int lettersInRow = 0, rowsInDoc = 0;
        Scanner scanner = new Scanner(System.in);
        h = scanner.nextInt();
        w = scanner.nextInt();
        n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            str = scanner.nextLine();

            if (rowsInDoc == 0) {rowsInDoc += 1;}

            if(lettersInRow + str.length() <= w) {
                lettersInRow += str.length() + 1;
            } else {
                lettersInRow = str.length() + 1;
                rowsInDoc += 1;
            }
        }
        scanner.close();
        pages = (double) rowsInDoc / h;
        pages = Math.ceil(pages);
        System.out.print((int)pages);
    }
}
