package lr7.task2;

public class Superclass {
    private String str;

    public void setStr(String str) {
        this.str = str;
    }

    public Superclass(String str) {
        this.str = str;
    }

    public int strLength() {
        return str.length();
    }
}

