package lr9.tasks;

import java.util.Scanner;

public class Task3 {
    private static Scanner scanner = new Scanner(System.in);

    private static void inputArray(int[] array) {
        inputArrayByIndex(array, 0);
    }

    private static void inputArrayByIndex(int[] array, int index) {
        if (index >= array.length) {
            return;
        }
        System.out.print("Введите элемент " + (index + 1) + ": ");
        array[index] = scanner.nextInt();
        inputArrayByIndex(array, index + 1);
    }

    private static void outputArray(int[] array) {
        outputArrayByIndex(array, 0);
    }

    private static void outputArrayByIndex(int[] array, int index) {
        if (index >= array.length) {
            return;
        }
        System.out.print(array[index] + " ");
        outputArrayByIndex(array, index + 1);
    }

    public static void main(String[] args) {
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        int[] array = new int[size];

        inputArray(array);
        System.out.print("Элементы массива: ");
        outputArray(array);
    }
}
