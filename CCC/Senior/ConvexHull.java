package CCC.Senior;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ConvexHull {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt(), n = sc.nextInt(), m = sc.nextInt();
        int[][] dis = new int[n + 1][k];
        boolean[][] vis = new boolean[n + 1][k];
        ArrayList<Triple>[] aList = new ArrayList[n + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dis[i + 1], Integer.MAX_VALUE);
            aList[i + 1] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), t = sc.nextInt(), h = sc.nextInt();
            aList[a].add(new Triple(h, t, b));
            aList[b].add(new Triple(h, t, a));
        }
        int a = sc.nextInt(), b = sc.nextInt();
        PriorityQueue<Triple> pq = new PriorityQueue<>();
        pq.add(new Triple(0, 0, a));
        dis[a][0] = 0;
        while (!pq.isEmpty()) {
            Triple t = pq.poll();
            if (dis[t.destination][t.hull] < t.time) continue;
            for (Triple triple : aList[t.destination]) {
                if (triple.hull + t.hull < k && dis[triple.destination][triple.hull + t.hull] > dis[t.destination][t.hull] + triple.time) {
                    dis[triple.destination][triple.hull + t.hull] = dis[t.destination][t.hull] + triple.time;
                    pq.add(new Triple(triple.hull + t.hull, dis[triple.destination][triple.hull + t.hull], triple.destination));
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            if (dis[b][i] < ans) ans = dis[b][i];
        }
        if (ans == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }
    public static class Triple implements Comparable<Triple> {
        int hull;
        int time;
        int destination;
        public Triple (int x, int y, int z) {
            hull = x;
            time = y;
            destination = z;
        }

        @Override
        public int compareTo(Triple o) {
            return Integer.compare(time, o.time);
        }
    }
}
