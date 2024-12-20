package lr7.task4;

public class Subclass extends Superclass {
    public String str;

    public Subclass(char symbol, String str) {
        super(symbol);
        this.str = str;
    }

    public Subclass(Subclass subc) {
        super(subc.symbol);
        this.str = subc.str;
    }
}

