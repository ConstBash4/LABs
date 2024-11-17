package lr4;

import java.util.Random;

public class lesson5 {

    public static void main(String[] args) {
        int lines = 3;
        int columns = 5;
        int[][] arr = new int[lines][columns];
        FillArrayRand(arr);
        OutputArray(arr);
        System.out.println("Turned:");
        int[][] turnedArray = ArrayLineToColumn(arr);
        OutputArray(turnedArray);
    }

    private static void FillArrayRand(int[][] array) {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = rand.nextInt(100);
            }
        }
    }

    private static int[][] ArrayLineToColumn(int[][] array) {
        int lines = array.length;
        int columns = array[0].length;
        int[][] turnedArray = new int[columns][lines];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                turnedArray[j][i] = array[i][j];
            }
        }
        return turnedArray;
    }

    private static void OutputArray(int[][] array) {
        for (int[] line : array) {
            for(int column : line) {
                System.out.print(column + " ");
            }
            System.out.print("\n");
        }
    }
}
