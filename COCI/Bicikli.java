package COCI;

import java.io.*;
import java.util.*;

public class Bicikli {
    public static long mod = (int) 1e9;
    public static boolean bool = false;
    public static boolean cycle = false;
    public static long[] dp;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        if (n == 1) {
            System.out.println(0);
            return;
        }
        boolean[] visited = new boolean[n + 1];
        ArrayList<Integer>[] aList = new ArrayList[n + 1];
        dp = new long[n + 1];
        for (int i = 0; i <= n; i++) aList[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            aList[a].add(b);
        }
        visited[2] = true;
        boolean[] temp = new boolean[n + 1];
        temp[2] = true;
        touched(1, aList, visited, temp);
        if (!visited[1]) {
            System.out.println(0);
            return;
        }
        long ans = recur(1, aList, new boolean[n + 1], new boolean[n + 1], visited);
        if (cycle || ans == -1) {
            System.out.println("inf");
        } else {
            if (bool) { // add leading 0s
                String string = String.valueOf(ans);
                for (int i = string.length(); i < 9; i++) System.out.print(0);
            }
            System.out.println(ans);
        }
    }

    public static boolean touched(int num, ArrayList<Integer>[] aList, boolean[] vis, boolean[] vis2) { // tree pruning
        vis2[num] = true;
        boolean ret = false;
        for (int next : aList[num]) {
            if (!vis2[next]) {
                if (touched(next, aList, vis, vis2)) {
                    ret = true;
                }
            } else if (vis[next]) {
                ret = true;
            }
        }
        return vis[num] = ret;
    }
    // vis = "did we go to this node before"
    // vis2 = is there a cycle?
    // vis3 = should we go to this node?
    public static long recur (int num, ArrayList<Integer>[] aList, boolean[] vis, boolean[] vis2, boolean[] vis3) { // technically topo sort but not really ...
        vis2[num] = true;
        vis[num] = true;
        long ans = 0;
        // System.out.println(num);
        for (int next : aList[num]) {
            if (next == 2) ans++;
            if (vis3[next]) {
                if (vis2[next]) { // cycle within the tree pruning = inf
                    cycle = true;
                    return -1;
                }
                if (!vis[next]) {
                    long temp = recur(next, aList, vis, vis2, vis3);
                    if (temp == -1) return -1;
                }
                ans += dp[next];
                if (ans >= mod) {
                    ans %= mod; bool = true;
                }
            }
        }
        vis2[num] = false;
        return dp[num] = ans;
    }
}