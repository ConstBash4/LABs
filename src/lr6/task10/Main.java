package lr6.task10;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arguments = {6,54,123,24,1,76,17};
        int[] MaxMin = TaskClass.MaxMinElement(arguments);
        System.out.printf("Arguments: %s; MaxMin: %s\n", Arrays.toString(arguments), Arrays.toString(MaxMin));
    }
}
