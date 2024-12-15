package lr6.task9;

public class TaskClass {
    public static void ReverseArray(int[] array) {
        int swap;
        for (int i = 0, j = array.length-1; i < array.length/2; i++, j--) {
            swap = array[i];
            array[i] = array[j];
            array[j] = swap;
        }
    }
}
