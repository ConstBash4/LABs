package lr5.task3;

public class Main {
    public static void main(String[] args) {
        taskClass obj = new taskClass();
        obj.outputNumber();
        obj = new taskClass(15);
        obj.outputNumber();
        obj = new taskClass(10, 20);
        obj.outputNumber();
    }
}