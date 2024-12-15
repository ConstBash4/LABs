package lr6.task8;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arguments = {6,54,123,24,1,76,17};
        double average = TaskClass.AverageArrayElements(arguments);
        System.out.printf("Arguments: %s; Average: %.3f\n", Arrays.toString(arguments), average);
    }
}
