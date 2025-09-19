package CCC.Junior;

import java.util.Scanner;

public class piDay {
    static long[][][] memo;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        memo = new long[n + 3][k + 3][n - k + 3];
        recursion(n, k, 1);
        System.out.println(memo[n][k][1]);
    }
    public static void recursion (int n, int k, int min) {
        if (memo[n][k][min] != 0) return;
        if (k == 1) {
            memo[n][k][min] = 1;
            return;
        }
        long sum = 0;
        if (min + 1 <= (int) Math.ceil(n * 1.0 / k)) {
            if (k * (min + 1) > n) {}
            else {
                recursion(n, k, min + 1);
                sum += memo[n][k][min + 1];
            }
        }
        recursion(n - min, k - 1, min);
        sum += memo[n - min][k - 1][min];
        memo[n][k][min] = sum;
    }
}
