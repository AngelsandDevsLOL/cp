package Random;

import java.util.*;

public class GiantAnts {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n, m, w;
        ArrayList<Integer>[] adj = new ArrayList[101];
        boolean[] vis = new boolean[101];
        int[] dist = new int[101];
        int[] distAnts = new int[101];
        n = scanner.nextInt();
        m = scanner.nextInt();
        for (int i = 0; i < 101; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }
        Queue<Integer> q = new LinkedList<>();
        w = scanner.nextInt();
        Arrays.fill(distAnts, Integer.MAX_VALUE);
        for (int i = 0; i < w; i++) {
            int a = scanner.nextInt();
            distAnts[a] = 0;  // 0 if ant
            vis[a] = true;    // true if ant
            q.add(a);         // ant
        }
        while (!q.isEmpty()) { // if q has ant
            int x = q.poll();  // ant
            for (int y : adj[x]) { // nodes connecting to ant node
                if (!vis[y]) { // if it is not visited
                    vis[y] = true; // visited
                    distAnts[y] = distAnts[x] + 1; // increase + !
                    q.add(y);  // woah new apocalypse
                }
            }
        }
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(vis, false); // everything is no longer visited?
        vis[1] = true;
        dist[1] = 0;
        q.add(1);
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int y : adj[x]) {
                if (!vis[y] && distAnts[y] * 4 > dist[x] + 1) {
                    vis[y] = true;
                    dist[y] = dist[x] + 1;
                    q.add(y);
                }
            }
        }
        if (dist[n] == Integer.MAX_VALUE) {
            System.out.println("sacrifice bobhob314");
        } else {
            System.out.println(dist[n]);
        }
    }
}
