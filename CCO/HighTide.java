package CCO;

import java.util.Arrays;
import java.util.Scanner;

public class HighTide {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] input = new int[n];
            for (int j = 0; j < n; j++) {
                input[j] = sc.nextInt();
            }
            Arrays.sort(input);
            int lcm = input[n - 1] * input[0];
            int gcd = input[n - 1] - input[0];
            int gcd3 = gcd(lcm, gcd);
            lcm /= gcd3;
            gcd /= gcd3;  // simplify the fraction
            for (int j = 1; j < n - 1; j++) { // do it again
                int numerator = input[n - 1] * input[j];
                int denominator = input[n - 1] - input[j];
                int gcd2 = gcd(numerator, denominator);
                numerator /= gcd2;
                denominator /= gcd2;
                gcd = gcd(gcd, denominator);
                lcm = lcm(lcm, numerator);
            }
            System.out.printf("%.2f", 1.0 * lcm / gcd);
            System.out.println();
        }
    }
    public static int lcm (int x, int y) {
        return (x * y) / gcd(x, y);
    }
    public static int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }
}