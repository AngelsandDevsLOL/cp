package Random;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class DirectedAcyclicGraph {
    static boolean bool = false;
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer>[] ar = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            ar[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = scanner.nextInt();
                if (x == 1) {
                    ar[i+1].add(j+1);
                }
            }
        }
        boolean[] vis = new boolean[n + 1];
        boolean[] dfsvis = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            dfs(ar, vis, dfsvis, i);
        }
        if (bool) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
    static void dfs (ArrayList<Integer>[] ar, boolean[] vis, boolean[] dfsvis, int cur) {
        for (int i : ar[cur]) {
            if (dfsvis[i]) {
                bool = true;
                return;
            }
            if (!vis[i]) {
                vis[i] = true;
                dfsvis[i] = true;
                dfs(ar, vis, dfsvis, i);
            }
        }
        dfsvis[cur] = false;
    }
}
