package lr7.task4;

public class SubSubclass extends Subclass {
    public int num;

    public SubSubclass(char symbol, String str, int num) {
        super(symbol, str);
        this.num = num;
    }

    public SubSubclass(SubSubclass subsubc) {
        super(subsubc.symbol, subsubc.str);
        this.num = subsubc.num;
    }
}
