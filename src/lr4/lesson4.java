package lr4;

public class lesson4 {
    public static void main(String[] args) {
        int height = 40;
        char[][] arr = new char[height][height];
        FillArray(arr);
        OutputArray(arr);
    }

    private static void FillArray(char[][] array) {
        int counter = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(counter > j) {
                    array[i][j] = '*';
                } else {
                    array[i][j] = ' ';
                }
            }
            counter++;
        }
    }

    private static void OutputArray(char[][] array) {
        for (char[] line : array) {
            for(char column : line) {
                System.out.print(column);
            }
            System.out.print("\n");
        }
    }
}
