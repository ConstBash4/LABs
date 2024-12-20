package lr7.task5;

public class Main {
    public static void main(String[] args) {
        Superclass objSuper = new Superclass("super str");
        Subclass objSub = new Subclass("sub str", 1);
        Subclass2 objSub2 = new Subclass2("sub2 str", 'a');

        objSuper.outputFields();
        objSub.outputFields();
        objSub2.outputFields();

        objSuper = objSub;
        objSuper.outputFields();

        objSuper = objSub2;
        objSuper.outputFields();
    }
}
