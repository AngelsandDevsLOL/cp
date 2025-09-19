package SAC;

import java.util.Scanner;

public class UnicycleLicense {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        long input = scanner.nextLong() - 1;
        long a = 12;
        long b = -5;
        long c = -1 * input;
        long num1 = -1 * b;
        double num2 = Math.sqrt((b * b) - (4 * a * c));
        long num4 = 2 * a;
        System.out.println((num1 + num2) / num4);
    }
}
