package CCC;

import java.io.*;
import java.util.*;

public class ConvexHull {
    public static int k;
    public static int b;
    public static int smallest = Integer.MAX_VALUE;
    public static ArrayList<Route>[] islands;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        k = readInt();
        int n = readInt(), m = readInt();
        islands = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            islands[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = readInt();
            int b = readInt();
            int t = readInt();
            int h = readInt();
            islands[a].add(new Route(b, t, h));
            islands[b].add(new Route(a, t, h));
        }
        int a = readInt();
        b = readInt();
        int[][] dis = new int[k + 1][n + 1];
        for (int[] row : dis) {
            Arrays.fill(row, -1);
        }
        for (int i = 0; i < k + 1; i++) {
            dis[i][a] = 0;
        }
        PriorityQueue<Route> pq = new PriorityQueue<Route>();
        for (Route r : islands[a]) {
            if (r.h >= k) continue;
            pq.add(r);
            dis[r.h][r.b] = r.t;
        }
        while (!pq.isEmpty()) {
            Route cur = pq.poll();
            for (Route r : islands[cur.b]) {
                if (cur.h + r.h < k && (dis[cur.h + r.h][r.b] > dis[cur.h][cur.b] + r.t || dis[cur.h + r.h][r.b] == -1)) {
                    dis[cur.h + r.h][r.b] = dis[cur.h][cur.b] + r.t;
                    if (r.b == b) break;
                    r.h = cur.h + r.h;
                    if (!pq.contains(r)) {
                        pq.add(r);
                    }
                }
            }
        }
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < k + 1; i++) {
            if (smallest > dis[i][b] && dis[i][b] != -1) smallest = dis[i][b];
        }
        System.out.println(smallest == Integer.MAX_VALUE ? -1 : smallest);
    }


    static class Route implements Comparable<Route> {
        int b;
        int t;
        int h;

        public Route(int b, int t, int h) {
            this.b = b;
            this.t = t;
            this.h = h;
        }
        public int compareTo(Route a) {
            return t - a.t;
        }
    }
    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    static String readLine() throws IOException {
        return br.readLine().trim();
    }
}