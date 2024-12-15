package lr6.task6;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arguments = {6,54,123,24,1,76,17};
        int n = -1;
        int[] newArray = TaskClass.arrayPointer(arguments, n);
        System.out.printf("Argument: %s; n: %d; newArray: %s\n", Arrays.toString(arguments), n, Arrays.toString(newArray));

        n = 3;
        newArray = TaskClass.arrayPointer(arguments, n);
        System.out.printf("Argument: %s; n: %d; newArray: %s\n", Arrays.toString(arguments), n, Arrays.toString(newArray));

        n = 20;
        newArray = TaskClass.arrayPointer(arguments, n);
        System.out.printf("Argument: %s; n: %d; newArray: %s; Same reference: %b\n",
                Arrays.toString(arguments), n, Arrays.toString(newArray), arguments==newArray);
    }
}
