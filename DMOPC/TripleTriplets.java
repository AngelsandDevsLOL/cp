package DMOPC;

import java.util.Scanner;

public class TripleTriplets {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long max = 0;
        for (int i = 1; i < n / 2; i++) {
            long num = calculate(i, n);
            if (num > max) {
                max = num;
            }
        }
        System.out.println(max);
    }
    public static long calculate(long twos, long num) {
        long ones = num - 2 * twos;
        return (ones * (ones - 1) / 2) * twos;
    }
}
