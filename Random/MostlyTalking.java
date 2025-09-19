package Random;

import java.io.*;
import java.util.*;

public class MostlyTalking {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = readInt(), m = readInt();
        ArrayList<Pair>[] aList = new ArrayList[n + 1];
        ArrayList<Pair>[] rev = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            aList[i] = new ArrayList<>();
            rev[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = readInt(), b = readInt(), k = readInt();
            aList[a].add(new Pair(b, k));
            rev[b].add(new Pair(a, k));
        }
        int d = readInt();
        long[] dis1 = bfs(aList, 1, n);
        long[] dis2 = bfs(rev, n, n);
        long smallest = dis1[n];
        for (int i = 0; i < d; i++) {
            int a = readInt();
            int b = readInt();
            int g = readInt();
            smallest = Math.min(smallest, dis1[a] + g + dis2[b]);
        }
        System.out.println(smallest >= INF ? -1 : smallest);
    }
    static long INF = (long) 1e18;
    public static long[] bfs (ArrayList<Pair>[] aList, int start, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        long[] dis = new long[n + 1];
        Arrays.fill(dis, INF);
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