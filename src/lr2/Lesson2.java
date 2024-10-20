package lr2;

import java.util.Scanner;

public class Lesson2 {

	public static void main(String[] args) {
		System.out.print("Введите число:");
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		scanner.close();
		if (num % 3 != 0) {
			System.out.printf("Число %d не делится на 3", num);
		} else {
			System.out.printf("Число %d делится на 3", num);
		}
	}

}
