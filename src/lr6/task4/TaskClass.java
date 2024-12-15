package lr6.task4;

public class TaskClass {

    public static int doubleFactorial(int n) {
        if(n < 0) {
            return  -1;
        } else if (n == 1 || n == 2) {
            return  n;
        }

        boolean even;
        if (n % 2 == 0) {
            even = true;
        } else {
            even = false;
        }

        int result = 1;
        for (;; n-=2) {
            result *= n;
            if ((n-2 == 0 && even) || (n-2 == -1 && !even)) {
                return result;
            }
        }
    }
}
