package lr5.task6;

public class Main {
    public static void main(String[] args) {
        taskClass obj = new taskClass(5);
        obj.outputNumbers();

        obj = new taskClass(-60,2);
        obj.outputNumbers();

        obj.setNumbers(53);
        obj.outputNumbers();

        obj.setNumbers(-122,122);
        obj.outputNumbers();

    }
}