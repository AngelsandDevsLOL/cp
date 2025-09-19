package CCCHK;

import java.util.Scanner;

public class WhenToMeet {
    public static int[] dp;
    public static int[] count;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n];
        count = new int[n];
        int[] path = new int[n];
        for (int i = 0; i < n; i++) {
            int room = sc.nextInt();
            path[i] = room - 1;
        }
        int maxAns = Integer.MIN_VALUE;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            recursion(i, vis, path, 1);
            maxAns = Math.max(maxAns, 2 * (dp[i]) - 2);
        }
        System.out.println(maxAns);
    }
    public static int recursion (int node, boolean[] vis, int[] path, int cnt) {
        if (dp[node] != 0) return -1;
        int next = path[node];
        vis[node] = true;
        int ans;
        count[node] = cnt;
        if (next == node) {
            dp[node] = count[node] - count[next] + 1;
            vis[node] = false;
            return -1;
        }
        if (vis[next]) {
            dp[node] = count[node] - count[next] + 1;
            vis[node] = false;
            return next;
        }
        ans = recursion(next, vis, path, cnt + 1);
        if (ans == node) {
            dp[node] = dp[next];
            ans = -1;
        }
        else if (ans >= 0) {
            dp[node] = dp[next];
        }
        else {
            dp[node] = dp[next] + 1;
        }
        vis[node] = false;
        return ans;
    }
}
