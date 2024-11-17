package lr4;

import java.util.Random;

public class lesson6 {
    static Random rand = new Random();

    public static void main(String[] args) {
        int lines = rand.nextInt(2,10);
        int columns = rand.nextInt(2,10);
        int[][] arr = new int[lines][columns];
        FillArrayRand(arr);
        OutputArray(arr);
        int remLine = rand.nextInt(0,arr.length);
        int remColumn = rand.nextInt(0,arr[0].length);
        System.out.printf("Removed Line %d and Column %d:\n", remLine, remColumn);
        int[][] remArray = ArrayRemoveLineAndColumn(arr, remLine, remColumn);
        OutputArray(remArray);
    }

    private static void FillArrayRand(int[][] array) {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = rand.nextInt(100);
            }
        }
    }

    private static int[][] ArrayRemoveLineAndColumn(int[][] array, int line, int column) {
        int lines = array.length-1;
        int columns = array[0].length-1;
        int[][] remArray = new int[lines][columns];
        int tA_i = 0;
        int tA_j = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == line) {
                continue;
            }
            for (int j = 0; j < array[i].length; j++) {
                if(j == column) {
                    continue;
                }
                remArray[tA_i][tA_j] = array[i][j];
                tA_j++;
            }
            tA_i++;
            tA_j = 0;
        }
        return remArray;
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
