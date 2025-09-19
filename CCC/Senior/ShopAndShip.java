package CCC.Senior;

import java.util.*;
import java.io.*;
public class ShopAndShip {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt();
        int t = readInt();
        ArrayList<Pair>[] aList = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            aList[i] = new ArrayList<>();
        }
        int[] dis = new int[n+1];
        boolean[] vis = new boolean[n+1];
        for (int i = 0; i < t; i++) {
            int x = readInt();
            int y = readInt();
            int c = readInt();
            aList[x].add(new Pair(y, c));
            aList[y].add(new Pair(x, c));
        }
        int k = readInt();
        Pair[] pencils = new Pair[k];
        for (int i = 0; i < k; i++) {
            int z = readInt();
            int p = readInt();
            pencils[i] = new Pair(z, p);
        }
        int d = readInt();
        Queue<Integer> q = new LinkedList<>();
        q.add(d);
        vis[d] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (Pair p : aList[cur]) {
                if (!vis[p.x] || dis[p.x] > dis[cur] + p.y) {
                    dis[p.x] = dis[cur] + p.y;
                    vis[p.x] = true;
                    q.add(p.x);
                }
            }
        }
        int small = Integer.MAX_VALUE;
        for (Pair p : pencils) {
            small = Math.min(small, dis[p.x] + p.y);
        }
        System.out.println(small);
    }
    static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
    static char readCharacter () throws IOException {
        return next().charAt(0);
    }
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}