package DMOPC;

import java.util.*;

public class HitchhikingFUn {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        ArrayList<Integer>[] aList = new ArrayList[n + 1];
        ArrayList<Integer>[] danger = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            aList[i] = new ArrayList<>();
            danger[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), t = sc.nextInt();
            if (t == 0) {
                aList[a].add(b);
                aList[b].add(a);
            } else {
                danger[a].add(b);
                danger[b].add(a);
            }
        }
        int[][] dis = bfs(aList, danger, n);
        if (dis[n][0] == x) {
            System.out.println(-1);
        } else
            System.out.println(dis[n][0] + " " + dis[n][1]);
    }
    static int x = (int) 1e5;
    public static int[][] bfs(ArrayList<Integer>[] aList, ArrayList<Integer>[] danger, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        int[][] dis = new int[n + 1][2];
        for (int[] row : dis) {
            Arrays.fill(row, x);
        }
        dis[1][0] = 0; dis[1][1] = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int x : aList[cur]) {
                if (dis[x][0] > dis[cur][0]) {
                    dis[x][0] = dis[cur][0];
                    dis[x][1] = dis[cur][1] + 1;
                    q.add(x);
                } else if (dis[x][0] == dis[cur][0] && dis[x][1] > dis[cur][1] + 1) {
                    dis[x][1] = dis[cur][1] + 1;
                    q.add(x);
                }
            }
            for (int x : danger[cur]) {
                if (dis[x][0] > dis[cur][0] + 1) {
                    dis[x][0] = dis[cur][0] + 1;
                    dis[x][1] = dis[cur][1] + 1;
                    q.add(x);
                } else if (dis[x][0] == dis[cur][0] + 1 && dis[x][1] > dis[cur][1] + 1) {
                    dis[x][1] = dis[cur][1] + 1;
                    q.add(x);
                }
            }
        }
        return dis;
    }
}
