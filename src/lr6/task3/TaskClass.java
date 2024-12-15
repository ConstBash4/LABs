package lr6.task3;

public class TaskClass {

    public  static  int highestValue(int... numbers) {
        int high = numbers[0];
        for (int current : numbers) {
            if(current > high) {
                high = current;
            }
        }
        return high;
    }

    public  static  int lowestValue(int... numbers) {
        int low = numbers[0];
        for (int current : numbers) {
            if(current < low) {
                low = current;
            }
        }
        return low;
    }

    public static double averageValue(int... numbers) {
        double sum = 0.0;
        for (int current : numbers) {
            sum += current;
        }
       return sum /= numbers.length;
    }
}
