package Random;

import java.util.*;

public class WOSSSightseeingInTheNorthPole {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Edge>[] aList = new ArrayList[n+1];
        for (int i = 0; i < n + 1; i++) {
            aList[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v =scanner.nextInt();
            int t = scanner.nextInt();
            aList[u].add(new Edge(v, t));
            aList[v].add(new Edge(u,t));
        }
        int s = scanner.nextInt();
        int e = scanner.nextInt();
        int[] dis = new int[n+1];
        Arrays.fill(dis, -1);
        dis[s] = 0;
        Queue<Integer> q = new LinkedList();
        q.add(s);
        while (!q.isEmpty()) { // bfs
            int cur = q.poll();
            for (Edge edge : aList[cur]) {
                if (dis[edge.y] > dis[cur] + edge.w || dis[edge.y] == -1) {
                    dis[edge.y] = dis[cur] + edge.w;
                    q.add(edge.y);
                }
            }
        }
        int travel = dis[e];
        Stack<Integer> stack = new Stack<>();
        stack.add(s);
        //while ()
    } public static void dfs (ArrayList<Edge>[] aList, int cur) {

    }
    public static class Edge {
        int y;
        int w;
        public Edge (int y,int w) {
            this.y = y;
            this.w = w;
        }
    }
}
