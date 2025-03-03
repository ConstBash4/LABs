package lr9.tasks.comparison;

import java.util.ArrayList;

public class AL {
    public static void main(String[] args) {
        int n = 2000000;
        //int n1 = 400000000;
        int n1 = 100000000;
        ArrayList<Integer> al = new ArrayList<>(n);
        fillList(al, n);
        System.out.print("Добавление элемента в начало - ");
        measureTime(() -> al.add(0, 1000));
        System.out.print("Добавление элемента в середину - ");
        measureTime(() -> al.add(al.size()/2, 1000));
        System.out.print("Добавление элемента в конец - ");
        measureTime(() -> al.add(1000));

        System.out.print("Удаление элемента из начала - ");
        measureTime(() -> al.remove(0));
        System.out.print("Удаление элемента в середине - ");
        measureTime(() -> al.remove(al.size()/2));
        System.out.print("Удаление элемента в конце - ");
        measureTime(() -> al.remove(al.size()-1));

        al.clear();
        ArrayList<Integer> bigAl = new ArrayList<>(n1);
        fillList(bigAl, n1);
        System.out.print("Получение элемента по индексу - ");
        measureTime(() -> bigAl.get(al.size()/2));
    }
    public static void measureTime(Runnable task) {
        long start = System.nanoTime();
        task.run();
        long end = System.nanoTime();
        long time = end - start;
        System.out.println("время выполнения: " + time/1000.0);
    }

    private static void fillList(ArrayList<Integer> c, int size) {
        for(int i = 0; i < size; i++) {
            c.add(i, i);
        }
    }
}
