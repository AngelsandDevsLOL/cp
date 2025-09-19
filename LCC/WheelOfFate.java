package LCC;

import java.util.Arrays;
import java.util.Scanner;

public class WheelOfFate {
    public static int[] dp;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] m = new int[n];
        dp = new int[(int) Math.pow(2, n)];
        Arrays.fill(dp, Integer.MIN_VALUE);
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            m[i] = sc.nextInt();
        }
        min(0, a, m, n,  0);
        System.out.println(dp[0]);
    }
    public static int min (int bit, int[] a, int[] m, int n, int ind) {
        if (dp[bit] != Integer.MIN_VALUE) return dp[bit];
        if (bit == (1 << n) - 1) return dp[bit] = 0;
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if ((bit | (1 << i)) != bit) { // 0
                min = Math.max(min, a[i] * m[(i - ind + n) % n] + min((bit | (1 << i)), a, m, n, ind + 1));
            }
        }
        return dp[bit] = min;
    }
}
