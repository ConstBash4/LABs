package lr5.task5;

public class Main {
    public static void main(String[] args) {
        taskClass obj = new taskClass();
        obj.outputNumber();

        obj = new taskClass(50);
        obj.outputNumber();

        obj = new taskClass(4546);
        obj.outputNumber();

        obj.setNumber();
        obj.outputNumber();

        obj.setNumber(57);
        obj.outputNumber();

        obj.setNumber(101);
        obj.outputNumber();
    }
}