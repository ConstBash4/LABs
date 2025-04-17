package lr12.tasks;

public class Task4 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
        }
    }
}
