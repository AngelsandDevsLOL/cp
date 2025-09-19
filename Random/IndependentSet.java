package Random;

import java.util.ArrayList;
import java.util.Scanner;

public class IndependentSet {
    public static long[][] dp;
    public static int mod = (int)(1e9 + 7);
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer>[] aList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            aList[i] = new ArrayList<>();
        }
        for (int i = 0; i < n- 1; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            aList[x].add(y);
            aList[y].add(x);
        }
        dp = new long[n + 1][2]; // [white, black]
        recursion(1, -1, aList);
        System.out.println((dp[1][0] + dp[1][1]) % mod);
    }
    public static void recursion (int cur, int prev, ArrayList<Integer>[] aList) {
        dp[cur][0] = 1; dp[cur][1] = 1;
        for (int next : aList[cur]){
            if (next == prev) continue;
            recursion(next, cur, aList);
            dp[cur][0] *= (dp[next][0] + dp[next][1]);
            dp[cur][1] *= dp[next][0];
            dp[cur][0] %= mod;
            dp[cur][1] %= mod;
        }
    }
}
