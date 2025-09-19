package DMOPC;

import java.util.Scanner;
public class Quest3 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), H = sc.nextInt();
        long[][] memo = new long[N+1][H + 1];
        for (int i = 1; i <= N; i++) {
            int g = sc.nextInt(), h = sc.nextInt(), q = sc.nextInt(), t = sc.nextInt();
            for (int j = H; j >= h; j--) {
                memo[i][j] = memo[i-1][j - h] + g;
            }
            for (int j = h + t; j <= H; j++) {
                memo[i][j] = Math.max(memo[i][j - t] + q, memo[i][j]);
            }
            for (int j = 0; j <= H; j++) {
                memo[i][j] = Math.max(memo[i][j], memo[i-1][j]);
            }

        }
        System.out.println(memo[N][H]);
    }
}