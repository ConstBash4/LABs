package timus.lr2_2012;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int f = scanner.nextInt();
		scanner.close();
		double time = ((12 - f)*45)/60.0;
		if (time > 4.0) {
			System.out.print("NO");
		} else {
			System.out.print("YES");
		}
	}
}
