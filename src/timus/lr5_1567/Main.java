package timus.lr5_1567;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String cost1 = "adgjmpsvy. ";
        String cost2 = "behknqtwz,";
        String cost3 = "cfilorux!";
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        scanner.close();
        int price = 0;
        char[] mes = message.toCharArray();
        for (char symbol : mes) {
            if(cost1.indexOf(symbol) != -1) {
                price += 1;
            } else if (cost2.indexOf(symbol) != -1) {
                price += 2;
            } else if (cost3.indexOf(symbol) != -1) {
                price += 3;
            }
        }
        System.out.print(price);
    }
}
