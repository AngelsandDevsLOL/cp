package DMOPC;

import java.util.*;

public class ThanksgivingFeast {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt();
        int[] shops = new int[k];
        for (int i = 0; i < k; i++) {
            shops[i] = sc.nextInt();
        }
        ArrayList<Integer>[] routes = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            routes[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            routes[x].add(y);
            routes[y].add(x);
        }
        int[] dis = bfs(routes, a, n);
        int[] dis2 = bfs(routes, b, n);
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            if (dis[shops[i]]!= -1 && dis2[shops[i]] != -1) {
                smallest = Math.min(smallest, dis[shops[i]] + dis2[shops[i]]);
            }
        }
        System.out.println(smallest);
    }
    public static int[] bfs(ArrayList<Integer>[] aList, int n, int size) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        boolean[] vis = new boolean[size + 1];
        vis[n] = true;
        int[] dis = new int[size + 1];
        Arrays.fill(dis, -1);
        dis[n] = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int x : aList[cur]) {
                if (!vis[x]) {
                    dis[x] = dis[cur] + 1;
                    vis[x] = true;
                    q.add(x);
                }
            }
        }
        return dis;
    }
}
