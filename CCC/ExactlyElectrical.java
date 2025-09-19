package CCC;

import java.util.Scanner;

public class ExactlyElectrical {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int t = scanner.nextInt();
        int y = Math.abs(d-b);
        int x = Math.abs(c-a);
        int sum = y + x;
        if (t - sum < 0) {
            System.out.println("N");
        } else if ((t-sum) % 2 == 0) {
            System.out.println("Y");
        } else {
            System.out.println("N");
        }
    }
}
