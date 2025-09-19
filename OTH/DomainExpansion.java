package OTH;

import java.util.*;
import java.io.*;

public class DomainExpansion {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in); // iddn't even use fast input-
        int n = sc.nextInt(), k = sc.nextInt();
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        int[][] input = new int[n][3];
        HashMap<Integer, Integer> strength = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int l = sc.nextInt(), r = sc.nextInt() + 1, s = sc.nextInt();
            input[i][0] = l;
            input[i][1] = r;
            input[i][2] = s;
            pq.add(new Pair(l, i + 1));
            strength.put(s, i);
        }
        int prev = 0;
        int[] ans = new int[n];
        TreeSet<Integer> domains = new TreeSet<>();
        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            if (!domains.isEmpty()) { // update
                int largest = domains.floor(Integer.MAX_VALUE);
                ans[strength.get(largest)] += p.x - prev;
            }

            if (p.s < 0) {
                domains.remove(input[-p.s - 1][2]);
            } else {
                domains.add(input[p.s - 1][2]);
                pq.add(new Pair(input[p.s - 1][1], -p.s));
            }
            prev = p.x;
        }
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }

    public static class Pair implements Comparable {
        int x;
        int s;

        public Pair(int xx, int ss) {
            x = xx;
            s = ss;
        }

        @Override
        public int compareTo(Object o) {
            if (x == ((Pair) o).x) return Integer.compare(s, ((Pair) o).s);
            return Integer.compare(x, ((Pair) o).x);
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

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