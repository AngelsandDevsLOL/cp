package Random;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GreedilyGamboling {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
        ArrayList<Pair>[] aList = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            aList[i] = new ArrayList<Pair>();
        }
        for (int i = 0; i < k; i++) {
            int x = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt();
            aList[u].add(new Pair(v, w));
            aList[v].add(new Pair(u,w));
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        boolean[] vis = new boolean[n+1];
        int[] dis = new int[n + 1];
        vis[1]= true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (Pair p : aList[cur]) {
                if (dis[p.v] > dis[cur] + p.w || (dis[p.v] == 0 && !vis[p.v])) {
                    dis[p.v] = dis[cur] + p.w;
                    q.add(p.v);
                    vis[cur] = true;
                }
            }
        }
        System.out.println(dis[n]);
    }
    static class Pair {
        int v;
        int w;
        public Pair (int v, int w){

            this.v = v;
            this.w = w;
        }
    }
}
