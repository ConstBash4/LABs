package lr6.task3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arguments = {6,54,123,24,1,76,17};
        int result = TaskClass.highestValue(arguments);
        System.out.printf("Arguments:%s; highest:%d\n", Arrays.toString(arguments), result);

        result = TaskClass.lowestValue(arguments);
        System.out.printf("Arguments:%s; lowest:%d\n", Arrays.toString(arguments), result);

        double res = TaskClass.averageValue(arguments);
        System.out.printf("Arguments:%s; average:%f\n", Arrays.toString(arguments), res);
    }
}
