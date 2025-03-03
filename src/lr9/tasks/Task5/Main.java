package lr9.tasks.Task5;

public class Main {
    public static void main(String[] args) {
        List list = new List();
        list.createByHead(new int[] {1,2,3,4,5});
        list.outputList();

        list = new List();
        list.createByTail(new int[] {6,7,8,9,10});
        list.outputList();
    }
}
