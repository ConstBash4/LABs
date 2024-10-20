package lr2;

import java.util.Scanner;

public class Lesson4 {

	public static void main(String[] args) {
		System.out.print("Введите число:");
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		scanner.close();
		if (num % 4 == 0 && num >= 10) {
			System.out.printf("Число %d делится на 4 и не меньше 10", num);
		} else {
			System.out.printf("Число %d не делится на 4 и/или меньше 10", num);
		}
	}
}
