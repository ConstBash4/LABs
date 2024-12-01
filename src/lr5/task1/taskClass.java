package lr5.task1;

public class taskClass {
    private char symbol;

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int getSymbolCode() {
        return (int)symbol;
    }

    public void outputSymbol() {
        System.out.printf("Symbol: %c\nSymbol code: %d\n", symbol, (int)symbol);
    }
}
