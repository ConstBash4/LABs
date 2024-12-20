package lr7.task1;

public class Subclass extends Superclass {
    private String str2;

    public Subclass(String str2) {
        this.str2 = str2;
    }

    public Subclass(String str, String str2) {
        super(str);
        this.str2 = str2;
    }

    @Override //переопределили метод toString в дочернем классе
    public String toString() {
        return "Subclass: " + str2 + " " + getStr();
    }
}
