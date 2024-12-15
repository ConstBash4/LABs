package lr6.task8;

public class TaskClass {
    public static double AverageArrayElements(int[] array) {
        double sum = 0.0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        sum /= array.length;
        return sum;
    }
}
