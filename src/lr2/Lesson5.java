package lr2;

import java.util.Scanner;

public class Lesson5 {

	public static void main(String[] args) {
		System.out.print("Введите число:");
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		scanner.close();
		if (num >= 5 && num <= 10) {
			System.out.printf("Число %d в диапазоне от 5 до 10 включительно", num);
		} else {
			System.out.printf("Число %d не в диапазоне от 5 до 10 включительно", num);
		}
	}
}
