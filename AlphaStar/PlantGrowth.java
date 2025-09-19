package AlphaStar;

import java.util.*;
import java.io.*;

public class PlantGrowth {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main (String[] args) throws IOException {
        int n = readInt();
        long x = readLong(), y = readLong(), z  = readLong();
        HashSet<Integer> current = new HashSet<>();
        long max = Math.max(x * n, z * n);
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int a = readInt(), b = readInt();
            pq.add(new Pair(a, 0, i));
            pq.add(new Pair(b, 1, i));
        }
        int underwatered = n;
        int overwatered = 0;
        // size of "perfectly watered" = current.size()
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            if (p.y == 0) { // add
                max = Math.max(underwatered * x + current.size() * y + overwatered*z, max);
                underwatered--;
                current.add(p.z);
            } else {
                max = Math.max(underwatered * x + current.size() * y + overwatered*z, max);
                overwatered++;
                current.remove(p.z);
            }
        }
        System.out.println(max);
    }
    public static class Pair implements Comparable {
        int x;
        int y;
        int z;
        public Pair (int xx, int yy, int zz) {x = xx; y = yy; z = zz;}

        @Override
        public int compareTo(Object o) {
            if (x == ((Pair)o).x) {
                return Integer.compare(y, ((Pair)o).y);
            }
            return Integer.compare(x, ((Pair)o).x);
        }
    }
    static String next () throws IOException {
        while (st == null || ! st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
}
