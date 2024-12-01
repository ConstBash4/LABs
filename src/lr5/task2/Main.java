package lr5.task2;

public class Main {
    public static void main(String[] args) {
        taskClass obj = new taskClass();
        obj.outputSequence();
        obj = new taskClass('F', 'X');
        obj.outputSequence();
        obj = new taskClass('Z', 'M');
        obj.outputSequence();
    }
}