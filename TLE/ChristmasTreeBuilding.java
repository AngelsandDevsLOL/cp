package TLE;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class ChristmasTreeBuilding {
    static int n, dia, far, dis[], pre[];
    static ArrayList<Pair>[] aList;
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int m = scanner.nextInt();
        int q = scanner.nextInt();
        aList = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            aList[i] = new ArrayList<>();
        }
        HashSet<Integer> hSet = new HashSet<>();
        int temp = 0;
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int l = scanner.nextInt();
            aList[u].add(new Pair(v, l));
            aList[v].add(new Pair(u, l));
            hSet.add(u);
            hSet.add(v);
            temp = u;
        }
        HashSet<Integer> nodes = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            if (!hSet.contains(i)) nodes.add(i);
        }
        dis = new int[n+1];
        pre = new int[n+1];
        dfs(temp, -1, 0); dia = 0; dfs(far, -1, 0);
        int rad = Integer.MAX_VALUE;
        int rad2 = Integer.MAX_VALUE;
        int index1 = 0;
        int index2 = 0;
        boolean bool = false;
        for (int i = far; i != -1; i = pre[i]) {
            if (dis[i] == dia - dis[i] && dis[i] > rad) {
                rad = dis[i];
                bool = true;
            }
            rad = Math.min(rad, Math.max(dis[i], dia - dis[i]));

        }
        if (q == 1) { // biggest
            System.out.println(dia + nodes.size());
        } else { // smallest
            if (bool) {
                System.out.println(rad + 1);
            } else
            System.out.println(rad);
        }
    }
    static void dfs(int cur, int par, int d) {
        pre[cur] = par;
        dis[cur] = d;
        if (d > dia) {
            dia = d;
            far = cur;
        }
        for (Pair p : aList[cur]) {
            if (p.v != par) dfs (p.v, cur, d + p.l);
        }
    }
    static class Pair {
        int v; // destination
        int l; // length
        Pair(int v, int l) {
            this.v = v;
            this.l = l;
        }
    }
}
