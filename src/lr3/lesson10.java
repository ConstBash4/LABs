package lr3;

import java.util.Random;

public class lesson10 {
    public static void main(String[] args) {
        int[] mas = new int[100];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = getRandomInt();
        }
        MasOutput(mas);
        MasOutput(sortMasDesc(mas));
    }

    private static int getRandomInt() {
        Random rand = new Random();
        return rand.nextInt(101); // случайное число 0-100
    }

    private static int[] sortMasDesc(int[] mas) {
        int n = mas.length;
        for(int i = 0; i<n-1; i++) {
            int minIndex = i;
            for(int j=i+1; j<n; j++) {
                if(mas[j]<mas[minIndex]) {
                    minIndex = j;
                }
            }
            if(minIndex!=i) {
                int a = mas[i];
                mas[i] = mas[minIndex];
                mas[minIndex] = a;
            }
        }
        return mas;
    }

    private static void MasOutput(int[] mas) {
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + " ");
        }
        System.out.print("\n");
    }
}
