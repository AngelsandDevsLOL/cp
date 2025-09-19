package WLMOJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PortalTravelling {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        ArrayList<Pair>[] aList = new ArrayList[n + 1];
        ArrayList<Pair>[] reverse = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            aList[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            aList[a].add(new Pair(b, c));
            reverse[b].add(new Pair(a, c));
        }
        int[] dis = bfs(1, aList);
        int[] dis2 = bfs(n, reverse);
        int best = dis[n];
        if (best == -1) {
            System.out.println(-1);
            return;
        }
        int secondBest = Integer.MAX_VALUE;
        for (int i = 2; i < aList.length - 1; i++) {
            for (Pair p : aList[i]) {
                if (dis[i] == Integer.MAX_VALUE || dis2[p.x] == Integer.MAX_VALUE) continue;
                int totalDistance = dis[i] + dis2[p.x] + p.y;
                if (totalDistance > best && totalDistance < secondBest) {
                    secondBest = totalDistance;
                }
            }
        }
        if (secondBest == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(secondBest);
    }
    public static int[] bfs (int start, ArrayList<Pair>[] aList) {
        int[] dis = new int[aList.length];
        boolean[] vis = new boolean[dis.length];
        Arrays.fill(dis, Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(start, 0));
        dis[start] = 0;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            if (vis[p.x]) continue;
            vis[p.x] = true;
            for (Pair pair : aList[p.x]) {
                if (dis[pair.x] > p.y + pair.y) {
                    pq.add(new Pair(pair.x, p.y + pair.y));
                    dis[pair.x] = p.y + pair.y;
                }
            }
        }
        return dis;
    }
    public static class Pair implements Comparable<Pair>{
        int x;
        int y;
        public Pair (int xx, int yy) {
            x = xx; y = yy;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(y, o.y);
        }
    }
}
