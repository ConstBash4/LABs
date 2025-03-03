package lr9.tasks.comparison;

import java.util.LinkedList;

public class LL {
    public static void main(String[] args) {
        int n = 2000000;
        //int n1 = 200000000;
        int n1 = 100000000;
        LinkedList<Integer> ll = new LinkedList<>();
        fillList(ll, n);
        System.out.print("Добавление элемента в начало - ");
        measureTime(() -> ll.add(0, 1000));
        System.out.print("Добавление элемента в середину - ");
        measureTime(() -> ll.add(ll.size()/2, 1000));
        System.out.print("Добавление элемента в конец - ");
        measureTime(() -> ll.add(1000));

        System.out.print("Удаление элемента из начала - ");
        measureTime(() -> ll.remove(0));
        System.out.print("Удаление элемента в середине - ");
        measureTime(() -> ll.remove(ll.size()/2));
        System.out.print("Удаление элемента в конце - ");
        measureTime(() -> ll.remove(ll.size()-1));

        ll.clear();
        LinkedList<Integer> bigLl = new LinkedList<>();
        fillList(bigLl, n1);
        System.out.print("Получение элемента по индексу - ");
        measureTime(() -> bigLl.get(ll.size()/2));
    }
    public static void measureTime(Runnable task) {
        long start = System.nanoTime();
        task.run();
        long end = System.nanoTime();
        long time = end - start;
        System.out.println("время выполнения: " + time/1000.0);
    }

    private static void fillList(LinkedList<Integer> c, int size) {
        for(int i = 0; i < size; i++) {
            c.add(i, i);
        }
    }
}
