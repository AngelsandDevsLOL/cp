package NoContest;

import java.util.Scanner;

public class LongestCommonSubsequence {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] first = new int[n + 1];
        int[] second = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            first[i] = sc.nextInt();
        }
        for (int i = 1; i <= m; i++) {
            second[i] = sc.nextInt();
        }
        int[][] memo = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (first[i] == second[j]) {
                    memo[i][j] = 1 + memo[i - 1][j - 1];
                } else {
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                }
            }
        }
        System.out.println(memo[n][m]);
    }
}
