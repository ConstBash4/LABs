package lr4;

public class lesson2 {
    public static void main(String[] args) {
        final char symbol = '*';
        int height = 15;
        int counter = 1;
        for (int i = 0; i < height; i++){
            for (int j = 0; j < counter; j++){
                System.out.print(symbol);
            }
            counter++;
            System.out.print("\n");
        }
    }
}
