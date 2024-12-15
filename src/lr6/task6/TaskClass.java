package lr6.task6;

public class TaskClass {

    public static int[] arrayPointer(int[] array, int n) {
        int[] newArray;
        if (array.length < n) {
            newArray = new int[array.length];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            return newArray;
        } else if (n <= 0) {
            return new int[0];
        }

        newArray = new int[n];
        for (int i = 0; i < n; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
}
