package lr7.task2;

public class Subclass extends Superclass {
    public int num;

    public Subclass(String str, int num) {
        super(str);
        this.num = num;
    }

    //перегрузили метод setStr
    public void setStr() {
        super.setStr("default");
    }

    //переопределили метод setStr
    @Override
    public void setStr(String str) {
        super.setStr(str + " override");
    }

    public void setNum() {
        this.num = 10;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setFields(String str, int num) {
        this.num = num;
        super.setStr(str);
    }
}