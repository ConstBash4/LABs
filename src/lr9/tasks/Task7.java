package lr9.tasks;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task7 {
    public static void main(String[] args) {
        Random rnd = new Random();
        int n = rnd.nextInt(11) + 10;
        //int n = 100000;
        System.out.println("Всего человек: " + n);
        System.out.println("ArrayList");
        circleList(new ArrayList<>(), n);
        System.out.println("LinkedList");
        circleList(new LinkedList<>(), n);
    }

    private static void circleList(List<Integer> people, int numberOfHumans) {
        long start = System.currentTimeMillis();
        for (int i = 1; i <= numberOfHumans; i++) {
            people.add(i);
        }

        int index = 0;

        while (people.size() > 1) {
            index = (index + 1) % people.size();
            System.out.println("Вычеркнут: " + people.remove(index));
            //people.remove(index);
        }
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("Оставшийся человек: " + people.get(0));
        System.out.println("Время выполнения: " + time);
    }
}
