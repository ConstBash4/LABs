package lr6.task7;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        char[] arguments = {'A','B','C','D'};
        int[] newArray = TaskClass.SymbolToCodes(arguments);
        System.out.printf("Arguments: %s; newArray: %s\n", Arrays.toString(arguments), Arrays.toString(newArray));
    }
}
