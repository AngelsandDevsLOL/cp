package NoContest;

import java.util.Scanner;

public class CodingSpree {
    public static int[][] memo;
    public static int[][] dis;
    public static int t;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        t = sc.nextInt();
        memo = new int[n + 1][t + 1];
        dis = new int[n][2];
        for (int i = 0; i < n; i++) {
            int v = sc.nextInt(), h = sc.nextInt();
            dis[i][0] = v;
            dis[i][1] = h;
        }
        for (int i = 1; i <= n; i++) {
            method(i);
        }
        System.out.println(memo[n][t]);
    }
    public static void method (int x) {
        for (int i = 0; i < t + 1; i++) {
            if (dis[x - 1][1] > i) {
                memo[x][i] = memo[x - 1][i];
            } else {
                memo[x][i] = Math.max(memo[x - 1][i], memo[x - 1][i - dis[x - 1][1]] + dis[x - 1][0]);
            }
        }
    }
}
