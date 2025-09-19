package IOI;

import java.util.Scanner;

public class Raisins {
    public static int[][][][] dp;
    public static int[][] psa;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        psa = new int[n + 1][m + 1];
        dp = new int[n + 1][m + 1][n + 1][m + 1]; // startX, startY, sizeX, sizeY
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                psa[i][j] = sc.nextInt() + psa[i - 1][j] + psa[i][j - 1] - psa[i - 1][j - 1];
            }
        }
        System.out.println(recur(1, 1, n, m));
    }
    public static int recur (int startX, int startY, int x, int y) {
        if (dp[startX][startY][x][y] != 0) return dp[startX][startY][x][y];
        if (startX == x && startY == y) return 0;
        int ans = Integer.MAX_VALUE;
        for (int i = startX; i < x; i++) {
            ans = Math.min(ans, recur(startX, startY, i, y) + recur(i + 1, startY, x, y));
        }
        for (int i = startY; i < y; i++) {
            ans = Math.min(ans, recur(startX, startY, x, i) + recur(startX, i + 1, x, y));
        }
        return dp[startX][startY][x][y] = ans + psa[x][y] + psa[startX - 1][startY - 1] - psa[startX - 1][y] - psa[x][startY - 1];
    }
}
