package CCCHK;

import java.util.Scanner;

public class WhenToMeet2 {
    public static void main (String[] args) { // brute force way
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] path = new int[n];
        for (int i = 0; i < n; i++) {
            int room = sc.nextInt();
            path[i] = room - 1;
        }
        int maxAns = Integer.MIN_VALUE;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            maxAns = Math.max(maxAns, 2 * recursion(i, vis, path) - 2);
        }
        System.out.println(maxAns);
    }
    public static int recursion (int node, boolean[] vis, int[] path) {
        int next = path[node];
        vis[node] = true;
        int ans;
        if (vis[next]) {
            vis[node] = false;
            return 1;
        } else {
            ans = recursion(next, vis, path) + 1;
        }
        vis[node] = false;
        return ans;
    }
}