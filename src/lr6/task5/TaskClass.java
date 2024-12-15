package lr6.task5;

public class TaskClass {

    public static int sumSquare(int n) {
        if(n < 0) {
            return -1;
        } else if (n == 0 || n == 1) {
            return n;
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i*i;
        }
        return sum;
    }
}
