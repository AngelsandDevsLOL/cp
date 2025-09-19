package Random;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SchoolTraversal {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Pair>[] edges = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), w = sc.nextInt();
            edges[a].add(new Pair(b, w));
        }
        int[] dis0 = bfs(edges, 0);
        int max = 0;
        int ind = 0;
        for (int i = 0; i < n; i++) {
            if (dis0[i] > max) {max = dis0[i]; ind = i;}
        }
        int[] dis1 = bfs(edges, ind);
        max = 0;
        ind = 0;
        for (int i = 0; i < n; i++) {
            if (dis1[i] > max) {max = dis1[i]; ind = i;}
        }
        int[] dis2 = bfs(edges, ind);
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int u = sc.nextInt(), v = sc.nextInt();

        }
    }
    public static int[] bfs (ArrayList<Pair>[] edges, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        int[] dis = new int[edges.length];
        boolean[] vis = new boolean[edges.length];
        vis[n] = true;
        while (!q.isEmpty()) {
            int num = q.poll();
            for (Pair p : edges[num]) {
                if (!vis[p.x]) {
                    vis[p.x] = true;
                    dis[p.x] = dis[num] + p.y;
                    q.add(p.x);
                }
            }
        }
        return dis;
    }
    public static class Pair {
        int x;
        int y;
        public Pair (int xx, int yy) {
            x = xx; y = yy;
        }
    }
}
