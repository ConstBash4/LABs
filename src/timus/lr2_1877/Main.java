package timus.lr2_1877;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int f_lock = scanner.nextInt();
		int s_lock = scanner.nextInt();
		scanner.close();

		if (f_lock % 2 == 0 || s_lock % 2 != 0) {
			System.out.print("yes");
		} else {
			System.out.print("no");
		}
	}
}
