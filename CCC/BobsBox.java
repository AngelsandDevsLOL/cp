package CCC;

import java.util.Scanner;

public class BobsBox {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        if (n % 2 == 0) {
            n = n / 2;
            n = n * (a + b);
            System.out.println(n);
        } else {
            n = n - 1;
            n = n/2;
            n = n * (a + b);
            n = n + a;
            System.out.println(n);
        }
    }
}
