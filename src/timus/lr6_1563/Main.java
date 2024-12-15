package timus.lr6_1563;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n, notVisited = 0;
        String[] shops;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        scanner.nextLine();
        shops = new String[n];
        for (int i = 0; i < n; i++) {
            shops[i] = scanner.nextLine();
            if(i > 0) {
                for(int j = 0; j < i; j++) {
                    if(Objects.equals(shops[j], shops[i])) {
                        notVisited++;
                        break;
                    }
                }
            }
        }
        scanner.close();
        System.out.printf("%d",notVisited);
    }
}
