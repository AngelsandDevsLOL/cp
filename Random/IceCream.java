package Random;

import java.util.ArrayList;
import java.util.Scanner;

public class IceCream {
    public static int impossible;
    public static boolean vis[];
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        ArrayList<Integer>[] aList = new ArrayList[n];
        int[][] ar = new int[n][n];
        for (int i = 0; i < n; i++) {
            aList[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1, b = sc.nextInt() - 1;
             aList[a].add(b);
             aList[b].add(a);
             ar[a][b] = -1;
             ar[b][a] = -1;
        }
        impossible = (n - 2) * m;
        vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (ar[i][j] == -1) {
                    if (vis[i]) continue;
                    vis[i] = true;
                    dfs(i, j, aList);
                    if (vis[j]) continue;
                    vis[j] = true;
                    dfs(j, i, aList);
                }
            }
        }
        System.out.println(impossible);
    }
    public static void dfs (int cur, int prev, ArrayList<Integer>[] aList) {
        for (int x : aList[cur]) {
            if (vis[x] || x == prev) continue;
            impossible++;
            vis[x] = true;
            dfs(x, cur, aList);
        }
    }
}
