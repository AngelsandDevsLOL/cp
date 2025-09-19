package NoContest;

import java.util.*;

public class SingleSourceShortestPath {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        ArrayList<Pair>[] aList = new ArrayList[n + 1];
        int[] dis = new int[n+1];
        boolean[] vis = new boolean[n+1];
        vis[1] = true;
        Arrays.fill(dis, -1);
        dis[1] = 0;
        for (int i = 0; i < n + 1; i++) {
            aList[i] = new ArrayList<Pair>();
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt();
            aList[u].add(new Pair(v, w));
            aList[v].add(new Pair(u, w));
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (Pair p : aList[cur]) {
                if (!vis[p.x] || dis[p.x] > dis[cur] + p.y) {
                    dis[p.x] = dis[cur] + p.y;
                    vis[p.x] = true;
                    q.add(p.x);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.println(dis[i]);
        }
    }
    static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
