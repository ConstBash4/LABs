package lr7.task3;

public class Superclass {
    public int num;

    public Superclass(int num) {
        this.num = num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Superclass: " + num;
    }
}

