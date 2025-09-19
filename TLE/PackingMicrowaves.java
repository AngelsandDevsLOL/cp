package TLE;

import java.util.Scanner;

public class PackingMicrowaves {
    static int a;
    static int b;
    static int c;
    static double n;
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextDouble();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();
        long min = Long.MAX_VALUE;
        int num = stuff(x, y, z);
        if (num < min) {
            min = num;
        }
        num = stuff(x, z, y);
        if (num < min) {
            min = num;
        }
        num = stuff(y, x, z);
        if (num < min) {
            min = num;
        }
        num = stuff(y, z, x);
        if (num < min) {
            min = num;
        }
        num = stuff(z, x, y);
        if (num < min) {
            min = num;
        }
        num = stuff(z, y, x);
        if (num < min) {
            min = num;
        }
        if (min == 2147483647) {
            System.out.println("SCAMMED");
        } else {
            System.out.println(min);
        }
    }
    static int stuff (int x, int y, int z) {
        double multiply = a / x;
        multiply = multiply * (b / y);
        multiply = multiply * (c / z);
        return (int) Math.ceil(n/multiply);
    }
}
