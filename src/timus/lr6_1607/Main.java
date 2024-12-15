package timus.lr6_1607;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] cost = new int[4];
        int finalCost;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < cost.length; i++) {
            cost[i] = scanner.nextInt(); //0 -  цена Пети; 1 - надбавка Пети; 2 - цена таксиста; 3 - скидка таксиста
        }
        scanner.close();
        if(cost[0] <= cost[2]) {
            for(;;) {
                if(cost[0] + cost[1] >= cost[2]) {
                    finalCost = cost[2];
                    break;
                } else {
                    cost[0] += cost[1];
                }
                if(cost[2] - cost[3] <= cost[0]) {
                    finalCost = cost[0];
                    break;
                } else {
                    cost[2] -= cost[3];
                }
            }
            System.out.printf("%d",finalCost);
        } else {
            System.out.printf("%d",cost[0]);
        }
    }
}
