package DMOPC;

import java.io.*;
import java.util.*;

public class BadBunnies {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static boolean[] vis2;
    public static void main (String args[]) throws IOException {

        int n = readInt();
        int r = readInt();
        ArrayList<Integer>[] ar = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            ar[i] = new ArrayList<>();
        }
        vis2 = new boolean[n];
        for (int i = 0; i < n - 1; i++) {
            int a = readInt()-1;
            int b = readInt()-1;
            ar[a].add(b);
            ar[b].add(a);
        }
        int[] rabbits = new int[r];
        for (int i = 0; i < r; i++) {
            rabbits[i] = readInt()-1;
        }
        int x = readInt()-1;
        int y = readInt()-1;
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        boolean[] vis = new boolean[n];
        vis[x] = true;
        int[] next = new int[n];
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == y) break;
            ArrayList<Integer> aList = ar[cur];
            for (int i : aList) {
                if (!vis[i]) {
                    q.add(i);
                    vis[i] = true;
                    next[i] = cur;
                }
            }
        }
        ArrayList<Integer> path = new ArrayList<>();
        while (next[y] != x) {
            path.add(y);
            y = next[y];
        }
        path.add(x);
        int small = Integer.MAX_VALUE;
        int[] dis = new int[n];
        for (int i : rabbits) {
            dis = (dfs(ar, i, n, dis));
        }
            for (int j : path) {
                small = Math.min(small, dis[j]);
            }
        System.out.println(small);
    }
    static int[] dfs(ArrayList<Integer>[] ar, int x, int n, int[] dis) {
        Stack<Integer> q = new Stack<>();
        q.add(x);
        boolean[] vis = new boolean[n];
        vis[x] = true;
        vis2[x] = true;
        dis[x] = 0;
        while (!q.isEmpty()) {
            int cur = q.pop();
            ArrayList<Integer> aList = ar[cur];
            for (int i : aList) {
                if (vis[i]) break;
                if (vis2[i] && dis[cur] + 1 >= dis[i]) break;
                q.add(i);
                vis[i] = true;
                dis[i] = dis[cur] + 1;
            }
        }
        return dis;
    }
    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(readLine());
        return st.nextToken();
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static int[] convert (String[] in) {
        int[] out = new int[in.length - 1];
        for (int i = 1; i < in.length; i++) out[i - 1] = Integer.parseInt(in[i]);
        return out;
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
