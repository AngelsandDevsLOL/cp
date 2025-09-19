package AlphaStar;

import java.util.*;
import java.io.*;

public class PencilShades {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static void main (String[] args) throws IOException {
        int n = readInt(), k = readInt();
        int counter = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        for (int i = 0; i < n; i++) {
            String[] in = readLine().split(" ");
            int num = Integer.parseInt(in[0]);
            if (in[1].equals("L")) {
                pq.add(new Pair(counter - num, 0));
                pq.add(new Pair(counter, 1));
                counter -= num;
            } else {
                pq.add(new Pair(counter, 0));
                pq.add(new Pair(counter + num, 1));
                counter += num;
            }
        }
        int curShade = 0;
        int pointer = 0;
        int ans = 0;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            if (curShade >= k) {
                ans += (p.x - pointer);
            }
            if (p.y == 0) {
                curShade++;
            } else {
                curShade--;
            }
            pointer = p.x;
        }
        System.out.println(ans);
    }
    public static String next () throws IOException {
        while (st == null || ! st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    public static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    public static String readLine () throws IOException {
        return br.readLine().trim();
    }
    public static class Pair implements Comparable {
        int x;
        int y;
        public Pair (int xx, int yy) {x = xx; y = yy;}

        @Override
        public int compareTo(Object o) {
            if (x == ((Pair)o).x) {
                return Integer.compare(y, ((Pair)o).y);
            }
            return Integer.compare(x, ((Pair)o).x);
        }
    }
}
