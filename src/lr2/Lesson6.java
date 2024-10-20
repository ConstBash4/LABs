package lr2;

import java.util.Scanner;

public class Lesson6 {

	public static void main(String[] args) {
		System.out.print("Введите число:");
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		scanner.close();
		int numOriginal = num;
		num = Math.abs(num);	//использование модуля числа из библиотеки математических операций
		int counter = 0;
		if (num - 1000 >= 0) {
			counter = num / 1000;
		}
		System.out.printf("Число %d содержит %d тысяч(у/и)", numOriginal, counter);
	}
}
