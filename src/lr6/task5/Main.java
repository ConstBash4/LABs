package lr6.task5;

public class Main {
    public static void main(String[] args) {
        int argument = 6;
        int result = TaskClass.sumSquare(argument);
        System.out.printf("Argument: %d; sum of squares: %d; check: %d\n", argument, result, argument*(argument+1)*(2*argument+1)/6);

        argument = 5;
        result = TaskClass.sumSquare(argument);
        System.out.printf("Argument: %d; sum of squares: %d; check: %d\n", argument, result, argument*(argument+1)*(2*argument+1)/6);

        argument = 10;
        result = TaskClass.sumSquare(argument);
        System.out.printf("Argument: %d; sum of squares: %d; check: %d\n", argument, result, argument*(argument+1)*(2*argument+1)/6);
    }
}
