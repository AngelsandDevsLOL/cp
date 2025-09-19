package COCI;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Bikili {
    public static int[] dp;
    public static long mod = (long) 1e9;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        ArrayList<Integer>[] aList = new ArrayList[n + 1];
        ArrayList<Integer>[] rev = new ArrayList[n + 1];
        dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            aList[i] = new ArrayList<>();
            rev[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            aList[a].add(b);
            rev[b].add(a);
        }
        boolean[] vis1 = new boolean[n + 1];
        boolean[] vis2 = new boolean[n + 1];
        vis1[2] = true;
        vis2[1] = true;

        dfs(1, new boolean[n + 1], vis1, aList);
        dfs(2, new boolean[n + 1], vis2, rev);
        boolean[] works = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++) {
            if (vis1[i] && vis2[i]) works[i] = true;
        }
        // System.out.println(dfs2(1, vis, new boolean[n + 1]));
    }
    public static boolean dfs (int node, boolean[] vis, boolean[] vis2, ArrayList<Integer>[] aList) {
        vis[node] = true;
        for (int next : aList[node]) {
            if (!vis[next]) {
                boolean nextAns = dfs(next, vis, vis2, aList);
                if (nextAns) {
                    return vis2[node] = true;
                }
            } else if (vis2[next]) {
                return vis2[node] = true;
            }
        }
        vis[node] = false;
        return false;
    }
    public static boolean dfs2 (int node, ArrayList<Integer>[] aList, boolean[] vis1, boolean[] vis2, boolean[] vis) {
        if (node == 2) return true;
        for (int next : aList[node]) {
            if (!vis[next]) {
                boolean nextAns = dfs(next, vis, vis2, aList);
                if (nextAns) {
                    return vis2[node] = true;
                }
            } else if (vis2[next]) {
                return vis2[node] = true;
            }
        }
        return false;
    }
}
