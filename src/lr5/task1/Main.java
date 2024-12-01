package lr5.task1;

public class Main {
    public static void main(String[] args) {
        taskClass obj = new taskClass();
        obj.setSymbol('=');
        System.out.println("Test symbol code: " + obj.getSymbolCode());
        obj.outputSymbol();
    }
}