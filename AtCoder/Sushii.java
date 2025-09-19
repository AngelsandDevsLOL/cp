package AtCoder;

import java.util.Scanner;

public class Sushii {
    public static double[][][] dp;
    public static int n;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] count = new int[3]; // {# of 1's, # of 2's, # of 3's}
        dp = new double[n + 1][n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            count[sc.nextInt() - 1]++;
        }
        recur(count[0], count[1], count[2]);
        System.out.println(dp[count[0]][count[1]][count[2]]);
    }
    public static void recur (int one, int two, int three) {
        if (dp[one][two][three] != 0 || one + two + three == 0) return;
        double sum = one + two + three;
        dp[one][two][three] = 1;
        if (one > 0) {
            recur(one - 1, two, three);
            dp[one][two][three] += 1.0 * one/n * dp[one - 1][two][three];
        } if (two > 0) {
            recur(one + 1, two - 1, three);
            dp[one][two][three] += 1.0 * two/n * dp[one + 1][two - 1][three];
        } if (three > 0) {
            recur(one, two + 1, three - 1);
            dp[one][two][three] += 1.0 * three/n * dp[one][two + 1][three - 1];
        }
        if (n == sum) return;
        dp[one][two][three] /= (1 - ((n - sum) / n));
    }
}
