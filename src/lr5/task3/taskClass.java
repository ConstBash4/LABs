package lr5.task3;

public class taskClass {
    private int first;
    private int second;

    public taskClass() {
        first = 0;
        second = 0;
    }

    public taskClass(int first) {
        this.first = first;
        this.second = 0;
    }

    public taskClass(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public void outputNumber() {
        System.out.printf("First: %d Second: %d\n", first, second);
    }
}
