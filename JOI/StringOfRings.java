package JOI;

import java.util.ArrayList;
import java.util.Scanner;

public class StringOfRings {
    public static int ans, node;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer>[] aList = new ArrayList[102];
        for (int i = 0; i <= 101; i++) {
            aList[i] = new ArrayList<>();
        }
        ans = 0; node = 0;
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            aList[a].add(b);
            aList[b].add(a);
        }
        boolean[] vis = new boolean[102];
        boolean[] vis2 = new boolean[102];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (!vis2[i]) {
                ans = 0;
                recursion(i, 1, vis, vis2, aList);
                ans = 0;
                recursion(node, 1, vis, vis2, aList);
                max = Math.max(max, ans);
            }
        }
        System.out.println(max);
    }
    public static void recursion (int cur, int d, boolean[] vis, boolean[] vis2, ArrayList<Integer>[] aList) {
        if (vis[cur]) return;
        vis[cur] = true; vis2[cur] = true;
        if (d > ans) {
            ans = d; node = cur;
        }
        for (int next : aList[cur]) {
            recursion(next, d + 1, vis, vis2, aList);
        }
        vis[cur] = false;
    }
}
