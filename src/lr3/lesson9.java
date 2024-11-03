package lr3;

import java.util.LinkedList;
import java.util.Random;

public class lesson9 {
    public static void main(String[] args) {
        int[] mas = new int[100];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = getRandomInt();
        }
        MasOutput(mas);
        int min = findMin(mas);
        LinkedList<Integer> indexes = findMinIndexes(mas, min);
        System.out.printf("Min element: %d\n", min);
        System.out.println("Indexes: " + indexes);
    }

    private static int getRandomInt() {
        Random rand = new Random();
        return rand.nextInt(101); // случайное число 0-100
    }

    private static int findMin(int[] mas) {
        int min = mas[0];
        for (int i = 1; i < mas.length; i++) {
            if (mas[i] < min) min = mas[i];
        }
        return min;
    }

    private static LinkedList<Integer> findMinIndexes(int[] mas, int element) {
        LinkedList<Integer> indexes = new LinkedList<>(); // создаем связный список с целыми числами
        for (int i = 1; i < mas.length; i++) {
            if (mas[i] == element) indexes.add(i);
        }
        return indexes;
    }

    private static void MasOutput(int[] mas) {
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + " ");
        }
        System.out.print("\n");
    }
}
