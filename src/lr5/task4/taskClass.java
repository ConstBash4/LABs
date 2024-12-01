package lr5.task4;

public class taskClass {
    private int number;
    private char symbol;

    public taskClass(int number, char symbol) {
        this.number = number;
        this.symbol = symbol;
    }

    public taskClass(double superNum) {
        int charNum = (int)superNum;
        symbol = (char)charNum;

        number = (int)((superNum - charNum)*100);
    }

    public void outputFields() {
        System.out.printf("Number: %d Symbol: %c\n", number, symbol);
    }
}
