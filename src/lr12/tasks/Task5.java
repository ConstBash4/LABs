package lr12.tasks;

import java.util.Random;

public class Task5 {

    private static final Object lock = new Object();
    //максимальный элемент
    private static int max;
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
        //за максимум берем 1-й элемент
        max = numbers[0];
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
                int tempMax;
                int tempPoint;
                int end;
                synchronized (lock) {
                    tempMax = max;
                    tempPoint = currentPoint;
                    currentPoint += segment;
                }
                //если это последний поток, то конец интервала - конец массива
                if(index == numberOfCores-1) {
                    end = numbers.length;
                } else {
                    end = tempPoint + segment;
                }
                for (int j = tempPoint; j < end; j++) {
                    if(tempMax < numbers[j]) {
                        tempMax = numbers[j];
                    }
                }
                synchronized (lock) {
                    if (max < tempMax) {
                        max = tempMax;
                    }
                }
                System.out.printf("%s стартовая позиция: %d, интервал: %d, максимальное значение %d\n",
                        Thread.currentThread().getName(), tempPoint, segment, tempMax);
            });
            threads[i].start();
        }
        //ждем завершения всех потоков
        for (Thread t : threads) {
            t.join();
        }

        System.out.printf("Изначальный массив: %d [ ", numbers.length);
        int checkMax = numbers[0];
        for (int i : numbers) {
            System.out.printf("%d ", i);
            if (i > checkMax) checkMax = i;
        }
        System.out.println("]");
        System.out.println("Максимальный элемент массива: " + max + " проверка " + checkMax);
    }
}
