package lr6.task4;

public class Main {
    public static void main(String[] args) {
        int argument = 6;
        int result = TaskClass.doubleFactorial(argument);
        System.out.printf("Argument:%d; double factorial:%d\n", argument, result);

        argument = 5;
        result = TaskClass.doubleFactorial(argument);
        System.out.printf("Argument:%d; double factorial:%d\n", argument, result);

        argument = 10;
        result = TaskClass.doubleFactorial(argument);
        System.out.printf("Argument:%d; double factorial:%d\n", argument, result);
    }
}
