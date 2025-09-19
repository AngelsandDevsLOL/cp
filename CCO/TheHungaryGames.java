package CCO;

import java.util.*;

public class TheHungaryGames {
    public static int n;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Pair>[] aList = new ArrayList[n + 1];
        ArrayList<Pair>[] aList2 = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            aList[i] = new ArrayList<>();
            aList2[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), l = sc.nextInt();
            aList[a].add(new Pair(b, l));
            aList[b].add(new Pair(a, l));
        }
        int[] dis = bfs(aList, 1);
        int[] dis2 = bfs(aList, n);
        if (dis[n] >= Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            int smallest = Integer.MAX_VALUE;
            for (int i = 1; i < n + 1; i++) {
                for (Pair p : aList[i]) {
                    if (dis[i] + p.l + dis2[p.x] > dis[n] && smallest > dis[i] + p.l + dis2[p.x]) {
                        smallest = dis[i] + p.l + dis2[p.x];
                    }
                }
            }
            System.out.println(smallest >= Integer.MAX_VALUE ? -1 : smallest);
        }
    }
    public static int[] bfs (ArrayList<Pair>[] aList, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[start] = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (Pair p : aList[cur]) {
                if ((dis[p.x] > dis[cur] + p.l)) {
                    dis[p.x] = dis[cur] + p.l;
                    q.add(p.x);
                }
            }
        }
        return dis;
    }
    static class Pair {
        int x;
        int l;
        public Pair(int x, int l) {
            this.x = x;
            this.l = l;
        }
    }
}
