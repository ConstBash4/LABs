package lr12.tasks;

import java.util.Random;

public class Task6 {

    private static final Object lock = new Object();
    //сумма элементов
    private static int sum = 0;
    //стартовая позиция в массиве для потока
    private static int currentPoint = 0;
    //интервал прохождения по массиву в потоке
    private static int segment ;
    //кол-во ядер ЦП (если массив больше)
    private static int numberOfCores;

    public static void main(String[] args) throws InterruptedException {
        //кол-во ядер процессора
        numberOfCores = Runtime.getRuntime().availableProcessors();
        Random random = new Random();
        //создаем массив с рандомными числами
        int n = random.nextInt(55) + 10;
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = random.nextInt(101);
        }
        //проверяем число потоков и длину массива
        if (numbers.length <= numberOfCores || (numbers.length/numberOfCores) == 1) {
            numberOfCores = numbers.length / 2;
            segment = 2;
        } else {
            segment = numbers.length / numberOfCores;
        }
        //создаем массив потоков
        Thread[] threads = new Thread[numberOfCores];
        for (int i = 0; i < numberOfCores; i++) {
            final int index = i;
            threads[i] = new Thread(() -> {
                int tempSum = 0;
                int tempPoint;
                int end;
                synchronized (lock) {
                    tempPoint = currentPoint;
                    currentPoint += segment;
                }
                //если это последний поток, то конец интервала - конец массива
                if(index == numberOfCores-1) {
                    end = numbers.length;
                } else {
                    end = tempPoint + segment;
                }
                for (int j = tempPoint; j < end; j++) { tempSum += numbers[j]; }
                synchronized (lock) { sum += tempSum; }
                System.out.printf("%s стартовая позиция: %d, интервал: %d, сумма элементов %d\n",
                        Thread.currentThread().getName(), tempPoint, segment, tempSum);
            });
            threads[i].start();
        }
        //ждем завершения всех потоков
        for (Thread t : threads) {
            t.join();
        }

        System.out.printf("Изначальный массив: %d [ ", numbers.length);
        int checkSum = 0;
        for (int i : numbers) {
            System.out.printf("%d ", i);
            checkSum += i;
        }
        System.out.println("]");
        System.out.println("Сумма элементов массива: " + sum + " проверка " + checkSum);
    }
}
