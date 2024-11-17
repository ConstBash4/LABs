package lr4;

public class lesson7 {

    public static void main(String[] args) {
        int lines = 10;
        int columns = 10;
        int[][] arr = new int[lines][columns];
        FillArraySnake(arr);
        OutputArray(arr);
    }

    private static void FillArraySnake(int[][] array) {
        int counter = 0;
        boolean straight = true;
        for (int i = 0; i < array.length; i++) {
            if(straight) {
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] = counter;
                    counter++;
                }
            } else {
                for (int j = array[i].length-1; j >= 0; j--) {
                    array[i][j] = counter;
                    counter++;
                }
            }
            straight = !straight;
        }
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
