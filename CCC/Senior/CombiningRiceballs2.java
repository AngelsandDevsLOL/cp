package CCC.Senior;

import java.util.Scanner;

public class CombiningRiceballs2 {
    public static int[] psa;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        psa = new int[n + 1];
        int ans = 0;
        boolean[][] dp = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            psa[i] = sc.nextInt();
            ans = Math.max(ans, psa[i]);
            psa[i] += psa[i - 1]; dp[i][i] = true;
        }
        for (int len = 0; len < n; len++) {
            for (int l = 1, r = 1 + len; r <= n; l++, r++) {
                for (int p = 1, q = r; p + 1 <= q;) {
                    if (dp[l][p] && dp[q][r] && (dp[p + 1][q - 1] || p + 1 == q) && sum(l, p) == sum(q, r)) {
                        dp[l][r] = true;
                        break;
                    }
                    if (sum(l, p) < sum(q, r)) p++;
                    else q--;
                }
                if (dp[l][r]) ans = Math.max(ans, sum(l, r));
            }
        }
        System.out.println(ans);
    }
    public static int sum (int x, int y) {
        return psa[y] - psa[x - 1];
    }
}
