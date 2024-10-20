package timus.lr2_1409;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int garry,larry;
		garry = scanner.nextInt();
		larry = scanner.nextInt();
		scanner.close();
		int total = garry + larry - 1;
		System.out.printf("%d %d", (total-garry), (total-larry));
	}
}
