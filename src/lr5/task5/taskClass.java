package lr5.task5;

public class taskClass {
    private int number;

    public void setNumber() {
        number = 0;
    }

    public void setNumber(int number) {
        if(number > 100) {
            this.number = 100;
        } else {
            this.number = number;
        }
    }

    public taskClass() {
        number = 0;
    }

    public taskClass(int number) {
        if(number > 100) {
            this.number = 100;
        } else {
            this.number = number;
        }
    }

    public void outputNumber() {
        System.out.printf("Number: %d\n", number);
    }
}
