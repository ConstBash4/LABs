package lr7.task3;

public class SubSubclass extends Subclass {
    public String str;

    public SubSubclass(char symbol, int num, String str) {
        super(symbol, num);
        this.str = str;
    }

    //перегрузка метода setNum
    public void setNum(String str, char symbol, int num) {
        this.str = str;
        this.symbol = symbol;
        this.num = num;
    }

    @Override
    public String toString() {
        return "SubSubclass: " + num + " " + symbol + " " + str;
    }
}
