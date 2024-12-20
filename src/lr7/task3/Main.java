package lr7.task3;

public class Main {
    public static void main(String[] args) {
        Superclass objSuper = new Superclass(10);
        System.out.println(objSuper.toString());

        objSuper.setNum(12);
        System.out.println(objSuper.toString());

        Subclass objSub = new Subclass('a', 555);
        System.out.println(objSub.toString());

        objSub.setNum('b',556);
        System.out.println(objSub.toString());

        SubSubclass objSubSub = new SubSubclass('c', 1024, "some str");
        System.out.println(objSubSub.toString());

        objSubSub.setNum("no some str", 'd', 2048);
        System.out.println(objSubSub.toString());
    }
}
