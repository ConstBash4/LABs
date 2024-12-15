package lr6.task7;

public class TaskClass {
    public static int[] SymbolToCodes(char[] array) {
        int[] codes = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            codes[i] = array[i];
        }
        return codes;
    }
}
