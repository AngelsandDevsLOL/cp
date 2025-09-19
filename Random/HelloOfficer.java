package Random;

import java.util.*;

public class HelloOfficer {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), b = sc.nextInt(), q = sc.nextInt();
        ArrayList<Pair>[] aList = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            aList[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt(), y = sc.nextInt(), z = sc.nextInt();
            aList[x].add(new Pair(y, z));
            aList[y].add(new Pair(x, z));
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(b);
        int[] dis = new int[n + 1];
        boolean[] vis = new boolean[n + 1];
        vis[b] = true;
        Arrays.fill(dis, -1);
        dis[b] = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (Pair p : aList[cur]) {
                if (!vis[p.x] || dis[p.x] > dis[cur] + p.y) {
                    dis[p.x] = dis[cur] + p.y;
                    vis[p.x] = true;
                    queue.add(p.x);
                }
            }
        }
        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            System.out.println(dis[a]);
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
