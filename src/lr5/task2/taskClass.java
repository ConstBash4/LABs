package lr5.task2;

public class taskClass {
    private char start;
    private char end;

    public taskClass(char start, char end) {
        this.start = start;
        this.end = end;
    }

    public taskClass() {
        start = 'A';
        end = 'Z';
    }

    public void outputSequence() {
        if ((int)start > (int)end) {
            System.out.println("Error sequence");
            return;
        }
        for (int i = (int)start; i <= (int)end; i++) {
            System.out.printf("%c ", i);
        }
        System.out.print("\n");
    }
}
