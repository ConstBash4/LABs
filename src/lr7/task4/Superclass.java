package lr7.task4;

public class Superclass {
    public char symbol;

    public Superclass(char symbol) {
        this.symbol = symbol;
    }

    public Superclass(Superclass superc) {
        this.symbol = superc.symbol;
    }
}
