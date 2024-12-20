package lr7.task5;

public class Subclass2 extends Superclass {
    protected char symbol;

    public Subclass2(String str, char symbol) {
        super(str);
        this.symbol = symbol;
    }

    @Override
    public void outputFields() {
        System.out.println("Subclass2: " + symbol);
    }
}

