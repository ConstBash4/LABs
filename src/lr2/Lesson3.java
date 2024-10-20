package lr2;

import java.util.Scanner;

public class Lesson3 {

	public static void main(String[] args) {
		System.out.print("Введите число:");
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		scanner.close();
		if (num % 5 == 2 && num % 7 == 1) {
			System.out.printf("Число %d при делении на 5 в остатке получается 2 И при делении на 7 в остатке получается 1", num);
		} else {
			System.out.printf("Число %d при делении на 5 в остатке (не)получается 2 И при делении на 7 в остатке (не)получается 1", num);
		}
	}
}
