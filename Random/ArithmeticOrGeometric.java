package Random;

import java.util.Scanner;

public class ArithmeticOrGeometric {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int k = scanner.nextInt();
            if (c - b == b - a) { // arithmetic
                int x = b - a;
                int num = Math.abs(a - x);
                if (a - x < 0) {
                    num = num * -1;
                }
                System.out.println(x * k + num);
            } else {
                int r = c/b;
                int number = (int) ((int) a * Math.pow(r, k - 1));
                System.out.println(number);
            }
        }
    }
}
