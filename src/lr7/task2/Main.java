package lr7.task2;

public class Main {
    public static void main(String[] args) {
        Superclass objSuper = new Superclass("super constructor str");
        System.out.println("Superclass: " + objSuper.strLength());

        Subclass objSub = new Subclass("12345",555);
        outputObj(objSub);

        objSub.setStr();
        outputObj(objSub);

        objSub.setStr("str");
        outputObj(objSub);

        objSub.setNum();
        outputObj(objSub);

        objSub.setNum(1000);
        outputObj(objSub);

        objSub.setFields("986", 222);
        outputObj(objSub);
    }

    public static void outputObj(Subclass obj) {
        System.out.println("Subclass: " + obj.num + ", strLength: " + obj.strLength());
    }
}
