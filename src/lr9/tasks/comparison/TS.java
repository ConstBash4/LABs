package lr9.tasks.comparison;

import java.util.TreeSet;

public class TS {
    public static void main(String[] args) {
        int n = 2000000;
        int n1 = 100000000;
        TreeSet<Integer> ts = new TreeSet<>();
        fillList(ts, n);
        System.out.print("Добавление элемента в начало - ");
        measureTime(() -> ts.add(-1));
        System.out.print("Добавление элемента в середину - ");
        measureTime(() -> ts.add(n/2));
        System.out.print("Добавление элемента в конец - ");
        measureTime(() -> ts.add(n+1));

        System.out.print("Удаление элемента из начала - ");
        measureTime(() -> ts.remove(-1));
        System.out.print("Удаление элемента в середине - ");
        measureTime(() -> ts.remove(n/2));
        System.out.print("Удаление элемента в конце - ");
        measureTime(() -> ts.remove(n+1));

        ts.clear();
        TreeSet<Integer> bigTs = new TreeSet<>();
        fillList(bigTs, n1);
        System.out.print("Получение элемента по индексу - ");
        measureTime(() -> bigTs.ceiling(ts.size()/2));
    }
    public static void measureTime(Runnable task) {
        long start = System.nanoTime();
        task.run();
        long end = System.nanoTime();
        long time = end - start;
        System.out.println("время выполнения: " + time/1000.0);
    }

    private static void fillList(TreeSet<Integer> ts, int size) {
        for(int i = 0; i < size; i++) {
            ts.add(i);
        }
    }
}
