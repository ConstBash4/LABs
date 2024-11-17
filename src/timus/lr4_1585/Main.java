package timus.lr4_1585;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int emp_penNum = 0;
        int lit_penNum = 0;
        int mac_penNum = 0;

        String emp_pen = "Emperor Penguin";
        String lit_pen = "Little Penguin";
        String mac_pen = "Macaroni Penguin";

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] str = new String[n];
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            str[i] = scanner.nextLine();
            if(str[i].contains(emp_pen)) {
                emp_penNum++;
            } else if (str[i].contains(lit_pen)) {
                lit_penNum++;
            } else if (str[i].contains(mac_pen)) {
                mac_penNum++;
            }
        }
        scanner.close();
        if (emp_penNum > lit_penNum) {
            if (emp_penNum > mac_penNum) {
                System.out.print(emp_pen);
            } else {
                System.out.print(mac_pen);
            }
        } else if(lit_penNum > mac_penNum) {
            System.out.print(lit_pen);
        } else {
            System.out.print(mac_pen);
        }
    }
}
