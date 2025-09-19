package CCC.Senior;

import java.util.Arrays;
import java.util.Scanner;

public class Tourism {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[][] ar = new int[n][(int) Integer.numberOfLeadingZeros(n)];
        for (int i = 0; i < n; i++) {
            ar[i][0] = sc.nextInt();
        }
        for (int i = 1; i < n; i *= 2) {
            for (int j = 0; j < n - i; j++) {
                ar[j][i] = Math.max(ar[j][i - 1], ar[j + i][i - 1]);
            }
        }
        memo = new int[n + 1][k + 1];
        System.out.println(recursion(ar, n, n % k == 0 ? n / k : n % k, k, (int) Math.ceil(n * 1.0 / k)));
    }
    public static int[][] memo;
    public static int recursion (int[][] max, int a, int b, int n, int t) {
        // a tourist things left from the end
        // b full days left
        // can do n tours in a full day
        // t total of days left

        if (memo[a][b] != 0) return memo[a][b];
        if (t == 0) return 0;
        // if a full day. start = n - a, end = n - a + n
        if (b > 0) {
            int x = Math.max(max[max.length - a][(int) (Math.log(n) / Math.log(2))], max[max.length - a + n - (int) (Math.log(n) / Math.log(2))][(int) (Math.log(n) / Math.log(2))]);
            if (memo[a - n][b - 1] != 0) {
                memo[a][b] = x + memo[a - n][b - 1];
            } else {
                memo[a][b] = x + recursion(max, a - n, b - 1, n, t - 1);
            }
        }

        // not a full day!!
        if (b < t) {
            int x = Math.max(max[max.length - a][(int) (Math.log(n - 1) / Math.log(2))], max[max.length - a + n - 1 - (int) (Math.log(n - 1) / Math.log(2))][(int) (Math.log(n - 1) / Math.log(2))]);
            if (memo[a - n + 1][b] != 0) {
                memo[a][b] = x + memo[a - n + 1][b];
            } else {
                memo[a][b] = x + recursion(max, a - n + 1, b, n, t - 1);
            }
        }
        return memo[a][b];
    }
}
