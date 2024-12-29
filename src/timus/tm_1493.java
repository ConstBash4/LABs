package timus;

import java.util.Scanner;

public class tm_1493 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nextN = n + 1;
        int prevN = n - 1;
        sc.close();
        if(happyTicket(nextN) || happyTicket(prevN)) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
    }

    private static boolean happyTicket(int num) {
        String strNum = Integer.toString(num);
        while (strNum.length() < 6) {
            strNum = "0" + strNum;
        }
        int[] arrNum = new int[6];
        int f_sum = 0, s_sum = 0;
        for (int i = 0; i < 6; i++) {
            if(i < 3) {
                f_sum += strNum.charAt(i) - '0';
            } else {
                s_sum += strNum.charAt(i) - '0';
            }
        }
        return f_sum == s_sum;
    }
}
