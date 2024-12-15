package lr6.task1;

public class TaskClass {
    private String string;
    private char aChar;

    public void setFields(char aChar) {
        this.aChar = aChar;
    }

    public void setFields(String string) {
        this.string = string;
    }

    public void setFields(char[] charArray) {
        if(charArray.length == 1) {
            aChar = charArray[0];
        } else {
            string = new String(charArray);
        }
    }

    public void outputFields() {
        System.out.printf("aChar: %c string: %s\n", aChar, string);
    }
}
