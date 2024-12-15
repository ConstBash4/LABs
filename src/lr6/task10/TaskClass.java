package lr6.task10;

public class TaskClass {
    public static int[] MaxMinElement(int... arguments) {
        int max = arguments[0], min = arguments[0];
        for (int item : arguments) {
            if(max < item) max = item;
            if(min > item) min = item;
        }
        int[] MaxMin = {min, max};
        return MaxMin;
    }
}
