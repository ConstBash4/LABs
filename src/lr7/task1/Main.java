package lr7.task1;

public class Main {
    public static void main(String[] args) {
        Superclass objSuper = new Superclass("super str");
        System.out.println(objSuper.toString());

        Subclass objSub = new Subclass("one str");
        System.out.println(objSub.toString());

        objSub = new Subclass("sub str", "super str");
        System.out.println(objSub.toString());
    }
}
