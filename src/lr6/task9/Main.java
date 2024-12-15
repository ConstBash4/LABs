package lr6.task9;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arguments = {6,54,123,24,1,76,17};
        int[] copyArguments = Arrays.copyOf(arguments, arguments.length);
        TaskClass.ReverseArray(copyArguments);
        System.out.printf("Arguments: %s; CopyArguments: %s\n", Arrays.toString(arguments), Arrays.toString(copyArguments));
    }
}
