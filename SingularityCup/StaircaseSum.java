package SingularityCup;

import java.util.Scanner;

public class StaircaseSum {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), q = sc.nextInt();
        int[][][] input = new int[n + 1][m + 1][2];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                input[i][j][0] = sc.nextInt();
                input[i][j][1] = input[i][j][0] + input[i][j - 1][0] + input[i - 1][j][0] - input[i - 1][j - 1][0];
            }
        }
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j < n; j++) {
                input[i][j][0] += input[i + 1][j][0] + input[i + 1][j + 1][0];
                if (i != n - 1){
                    input[i][j][0] -= input[i + 2][j + 1][0];
                }
            }
        }
        for (int i = 0; i < q; i++) {

        }
    }
}
