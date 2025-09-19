package Random;

import java.util.Arrays;
import java.util.Scanner;

public class LCS {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] first = sc.nextLine().toCharArray();
        char[] second = sc.nextLine().toCharArray();
        int n = first.length, m = second.length;
        int[][] memo = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (first[i - 1] == second[j - 1]) {
                    memo[i][j] = 1 + memo[i - 1][j - 1];
                } else {
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                }
            }
        }
        int num = memo[n][m];
        int i = n;
        int j = m;
        StringBuilder sb = new StringBuilder();
        while (i > 0 && j > 0) {
            if (first[i - 1] == second[j - 1]) {
                sb.insert(0, first[i - 1]);

                i--;
                j--;
                num--;
            }
            else if (memo[i - 1][j] > memo[i][j - 1])
                i--;
            else
                j--;
        }
        System.out.println(sb.toString());
    }
}
