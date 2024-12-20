package lr7.task3;

public class Subclass extends Superclass {
    public char symbol;

    public Subclass(char symbol, int num) {
        super(num);
        this.symbol = symbol;
    }
    //перегрузка метода setNum
    public void setNum(char symbol, int num) {
        this.symbol = symbol;
        this.num = num;
    }

    @Override
    public String toString() {
        return "Subclass: " + num + " " + symbol;
    }
}

