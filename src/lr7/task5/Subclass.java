package lr7.task5;

public class Subclass extends Superclass {
    protected int num;

    public Subclass(String str, int num) {
        super(str);
        this.num = num;
    }

    @Override
    public void outputFields() {
        System.out.println("Subclass: " + num);
    }
}


