package COCI;

import java.util.Scanner;

public class Nered {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] psa = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int r = sc.nextInt(), c = sc.nextInt();
            psa[r][c] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                psa[i][j] += psa[i - 1][j] + psa[i][j - 1] - psa[i - 1][j - 1];
            }
        }
        int ans = m - 1;
        for (int i = 1; i <= n && i <= m; i++) {
            if (m % i == 0) {
                int x = m / i; // x by i rectangle
                for (int j = x; j <= n; j++) {
                    for (int k = i; k <= n; k++) {
                        int num = psa[j][k] + psa[j - x][k - i] - psa[j - x][k] - psa[j][k - i];
                        ans = Math.min(ans, m - num);
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
