package COCI;

import java.util.*;
import java.io.*;

public class Grundanje { // total fial
    public static void main(String[] args) throws IOException {
        String input = readLine();
        int n = input.length(), q = readInt();
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        for (int i = 0; i < q; i++) {
            int a = readInt() - 1, b = readInt();
            pq.add(new Pair(a, 1));
            pq.add(new Pair(b, -a));
        }
        int[] order = new int[n];
        for (int i = 0; i < n; i++) {
            order[i] = readInt() - 1;
        }
        System.out.println(bSearch(0, n, pq, order, input));
    }

    public static int bSearch(int low, int high, PriorityQueue<Pair> pq, int[] order, String input) {
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            TreeSet<Integer> temp = new TreeSet<>();
            for (int i = 0; i < mid; i++) {
                temp.add(order[i]);
            }
            if (works(pq, temp, input)) {
                high = mid - 1;
                ans = mid;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static boolean works(PriorityQueue<Pair> pq, TreeSet<Integer> tSet, String input) {
        int[] prev = new int[26];
        Arrays.fill(prev, -1);
        PriorityQueue<Pair> temp = new PriorityQueue<>();
        temp.addAll(pq);
        TreeMap<Integer, Integer> ranges = new TreeMap<>();
        int cur = 0; // not touched yet
        while (!temp.isEmpty()) {
            Pair p = temp.poll();
            if (ranges.isEmpty()) {
                cur = p.x;
            }
            int max = Integer.MAX_VALUE;
            for (int x : ranges.keySet()) {
                max = x;
                break;
            }
            for (; cur < p.x; cur++) {
                if (!tSet.contains(cur)) {
                    if (prev[input.charAt(cur) - 'a'] >= max) {
                        return false;
                    } else {
                        prev[input.charAt(cur) - 'a'] = cur;
                    }
                }
            }
            if (p.y == 1) {
                if (ranges.containsKey(p.x)) ranges.put(p.x, ranges.get(p.x) + 1);
                else ranges.put(p.x, 1);
            } else if (ranges.get(-p.y) == 1) ranges.remove(-p.y);
            else ranges.put(-p.y, ranges.get(-p.y) - 1);
        }
        return true;
    }

    public static class Pair implements Comparable {
        int x;
        int y;

        public Pair(int xx, int yy) {
            x = xx;
            y = yy;
        }

        @Override
        public int compareTo(Object o) {
            if (x == ((Pair) o).x) return Integer.compare(y, ((Pair) o).y);
            else return Integer.compare(x, ((Pair) o).x);
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