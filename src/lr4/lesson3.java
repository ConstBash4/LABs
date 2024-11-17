package lr4;

import java.util.Arrays;

public class lesson3 {
    public static void main(String[] args) {
        int width = 30;
        int height = 40;
        int[][] arr = new int[height][width];
        FillArray2(arr);
        OutputArray(arr);
    }

    private static void FillArray2(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            Arrays.fill(array[i], 2); //метод, присваивающий указанное значение int каждому элементу указанного массива
        }
    }

    private static void OutputArray(int[][] array) {
        for (int[] line : array) {
            for(int column : line) {
                System.out.print(column);
            }
            System.out.print("\n");
        }
    }
}
