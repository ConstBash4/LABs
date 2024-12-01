package lr5.task6;

import java.util.Arrays;

public class taskClass {
    private int min;
    private int max;

    public void setNumbers(int num) {
        if(min > num) {
            min = num;
        } else if(num > max) {
            max = num;
        }
    }

    public void setNumbers(int num, int num1) {
        int[] arr = new int[4];
        arr[0] = min;
        arr[1] = max;
        arr[2] = num;
        arr[3] = num1;
        Arrays.sort(arr);
        min = arr[0];
        max = arr[3];
    }

    public taskClass(int num) {
        if(min > num) {
            min = num;
        } else if(num > max) {
            max = num;
        }
    }
    //т.к. в Java int имеет значение по-умолчанию 0, то проверка идет вне зависимости от того, инициализированы переменные max и min или нет
    public taskClass(int num, int num1) {
        int[] arr = new int[4];
        arr[0] = min;
        arr[1] = max;
        arr[2] = num;
        arr[3] = num1;
        Arrays.sort(arr);
        min = arr[0];
        max = arr[3];
    }

    public void outputNumbers() {
        System.out.printf("Min: %d Max: %d\n", min, max);
    }
}
