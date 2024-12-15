package lr6.task1;

public class Main {
    public static void main(String[] args) {
        TaskClass obj = new TaskClass();
        obj.setFields('a');
        obj.setFields("this string");
        obj.outputFields();

        char[] charArray = {'A','B','C'};
        obj.setFields(charArray);
        charArray = new char[1];
        charArray[0] = '0';
        obj.setFields(charArray);
        obj.outputFields();
    }
}
