package timus.lr10_1243;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String itemsStr = scanner.nextLine();

        BigInteger items = new BigInteger(itemsStr);
        BigInteger divider = new BigInteger("7");
        BigInteger splitItems = items.mod(divider);

        System.out.println(splitItems);
        scanner.close();
    }
}