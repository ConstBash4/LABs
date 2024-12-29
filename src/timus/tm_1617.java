package timus;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class tm_1617 {
    public static void main(String[] args) {
        Map<Integer,Integer> wheelPairs = new HashMap<Integer,Integer>();
        int wagons = 0;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] wheels = new int[n];
        for (int i = 0; i < n; i++) {
            wheels[i] = sc.nextInt();
            if(!wheelPairs.containsKey(wheels[i])) {
                wheelPairs.put(wheels[i], 1);
            } else {
                wheelPairs.replace(wheels[i], wheelPairs.get(wheels[i]) + 1);
            }
        }
        sc.close();

        for (Map.Entry<Integer, Integer> item : wheelPairs.entrySet()) {
            if(item.getValue() >= 4) {
                wagons += item.getValue() / 4;
            }
        }

        System.out.print(wagons);
    }
}
