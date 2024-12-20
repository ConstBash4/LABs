package lr7.task1;

public class Superclass {
    private String str;

    public Superclass() {}

    public Superclass(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    @Override //переопределили базовый метод toString в родительском классе
    public String toString() {
       return "Superclass: " + str;
    }
}
