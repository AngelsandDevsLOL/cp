package NoContest;

import java.io.*;
import java.util.*;

public class DisjointSetTest {
    public static int[] parent;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int m = readInt();
        parent = new int[n + 1];
        ArrayList<Integer> aList = new ArrayList<>();
        int c = 1;
        for (int i = 0; i < m; i++) {
            int u = readInt();
            int v = readInt();
            int p1 = find(u);
            int p2 = find(v);
            if (p1 != p2) {
                parent[p2] = p1;
                aList.add(c);
            }
            c++;
        }
        if (aList.size() != n - 1) System.out.println("Disconnected Graph");
        else {
            for (int i = 0; i < aList.size(); i++) {
                System.out.println(aList.get(i));
            }
        }
    }
    public static int find (int x) {
        if (parent[x] != 0) {
            parent[x] = find(parent[x]);
        }
        if (parent[x] == 0) return x;
        return parent[x];
    }
    static class Pair {
        int x;
        int y;
        public Pair (int x, int y) {
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

