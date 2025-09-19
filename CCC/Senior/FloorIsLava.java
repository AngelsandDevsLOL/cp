package CCC.Senior;

import java.io.*;
import java.util.*;

public class FloorIsLava {
    public static void main (String[] args) throws IOException {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int n = readInt(), m = readInt();
        long[] dis = new long[n + 1];
        Arrays.fill(dis, Long.MAX_VALUE);
        dis[1] = 0;
        ArrayList<Integer>[] aList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            aList[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = readInt(), b = readInt(), c = readInt();
            aList[a].add(b); aList[a].add(c);
            aList[b].add(a); aList[b].add(c);
        }
        pq.add(new Pair(0, 0, 1));
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int cur = p.node;
            for (int i = 0; i < aList[cur].size(); i += 2) {
                int next = aList[cur].get(i);
                int hotness = aList[cur].get(i + 1);
                if (dis[next] >= p.dis + Math.abs(hotness - p.hotness)) {
                    dis[next] = p.dis + Math.abs(hotness - p.hotness);
                    pq.add(new Pair(dis[next], hotness, next));
                }
            }
            if (p.dis >= dis[n]) break;
        }
        System.out.println(dis[n]);
    }
    public static class Pair implements Comparable {
        long dis;
        int hotness;
        int node;
        public Pair(long d, int h, int n) {
            dis = d; hotness = h; node = n;
        }

        @Override
        public int compareTo(Object o) {
            return Long.compare(dis, ((Pair)o).dis);
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int mod = (int) 1e9+7;

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
    static int readLongLineInt() throws IOException{
        int x = 0, c;
        while((c = br.read()) != ' ' && c != '\n')
            x = x * 10 + (c - '0');
        return x;
    }
    static long pow (long x, long exp){
        if (exp==0) return 1;
        long t = pow(x, exp/2);
        t = t*t %mod;
        if (exp%2 == 0) return t;
        return t*x%mod;
    }
    static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
    static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
