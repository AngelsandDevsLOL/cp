package CCC.MockS;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        int n = readInt(), r = readInt();
        int[][] ar = new int[n][4];
        for (int i = 0; i < n; i++) {
            int x1 = readInt(), y1 = readInt(), x2 = readInt() - 1, y2 = readInt() - 1;
            ar[i][0] = x1; ar[i][1] = y1; ar[i][2] = x2; ar[i][3] = y2;
            pq.add(new Pair(i, x1));
            pq.add(new Pair(-i, x2));
        }
        PriorityQueue<Pair> pq2 = new PriorityQueue<>();
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            if (p.type <= 0) pq2.remove();
            while (!pq.isEmpty() && pq.peek().x == p.x) {
                Pair pair = pq.poll();

            }
        }
    }
    public static class Pair implements Comparable {
        int x;
        int type;
        public Pair (int t, int xx) {
            type = t; x = xx;
        }

        @Override
        public int compareTo(Object o) {
            if (x == ((Pair)o).x) {
                return Integer.compare(type, ((Pair)o).type);
            } return Integer.compare(x, ((Pair)o).x);
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