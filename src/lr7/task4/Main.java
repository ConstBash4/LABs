package lr7.task4;

public class Main {
    public static void main(String[] args) {
        Superclass objSuper = new Superclass('a');
        System.out.println("objSuper: " + objSuper.symbol);

        Superclass objSuperCopy = new Superclass(objSuper);
        System.out.println("objSuperCopy: " + objSuperCopy.symbol);

        Subclass objSub = new Subclass('b',"str1");
        System.out.printf("objSub: %c, %s\n", objSub.symbol, objSub.str);

        Subclass objSubCopy = new Subclass(objSub);
        System.out.printf("objSubCopy: %c, %s\n", objSubCopy.symbol, objSubCopy.str);

        SubSubclass objSubSub = new SubSubclass('c', "str2", 1);
        System.out.printf("objSubSub: %c, %s, %d\n", objSubSub.symbol, objSubSub.str, objSubSub.num);

        SubSubclass objSubSubCopy = new SubSubclass(objSubSub);
        System.out.printf("objSubSubCopy: %c, %s, %d\n", objSubSubCopy.symbol, objSubSubCopy.str, objSubSubCopy.num);
    }
}
