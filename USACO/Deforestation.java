package USACO;

import java.util.*;
import java.io.*;

public class Deforestation {
    public static int[][] q;
    public static void main (String[] args) throws IOException {
        int t = readInt();
        for (int i = 0; i < t; i++) {
            int n = readInt(), k = readInt();
            int[] trees = new int[n];
            for (int j = 0; j < n; j++) {
                trees[j] = readInt() + (int) 1e9;
            }
            Arrays.sort(trees);
            TreeMap<Integer, Integer> tMap = new TreeMap<>();
            tMap.put(-1, 0);
            int sum = 0;
            for (int j = 0; j < n; j++) {
                tMap.put(trees[j], sum += 1);
            }
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            q = new int[k][3];
            for (int j = 0; j < k; j++) {
                int x = readInt() + (int) 1e9, y = readInt() + (int) 1e9, min = readInt();
                pq.add(new Pair(x, j));
                int treesToCut = tMap.get(tMap.floorKey(y)) - tMap.get(tMap.floorKey(x - 1));
                q[j][0] = x; q[j][1] = y; q[j][2] = treesToCut - min;
            }
            int dead = 0;
            int l; // [l, r)
            int r = pq.peek().start;
            dead += tMap.get(tMap.floorKey(r - 1));
            TreeMap<Integer, Integer> min = new TreeMap<>();
            while (!pq.isEmpty()) {
                l = pq.peek().start;
                while (!pq.isEmpty() && pq.peek().start == l) {
                    Pair next = pq.poll();
                    if (q[next.index][0] < 0) { // delete smthing
                        int curMin = -q[next.index][0];
                        if (min.get(curMin) == 1) {
                            min.remove(curMin);
                        } else min.put(curMin, min.get(curMin) - 1);
                    } else { // add smthing
                        pq.add(new Pair(q[next.index][1] + 1, next.index));
                        int curMin = dead + q[next.index][2];
                        if (min.containsKey(curMin)) min.put(curMin, min.get(curMin) + 1);
                        else min.put(curMin, 1);
                        q[next.index][0] = -curMin;
                    }
                }
                if (pq.isEmpty()) {
                    r = Integer.MAX_VALUE;
                } else {
                    r = pq.peek().start;
                }
                if (min.isEmpty()) {
                    dead += tMap.get(tMap.floorKey(r - 1)) - tMap.get(tMap.floorKey(l - 1));
                } else {
                    int smallest = min.firstKey() - dead;
                    int death = Math.min(smallest, tMap.get(tMap.floorKey(r - 1)) - tMap.get(tMap.floorKey(l - 1)));
                    dead += death;
                }
            }
            System.out.println(dead);
        }
    }
    public static class Pair implements Comparable {
        int start;
        int index;
        public Pair (int s, int i) {
            start = s; index = i;
        }

        @Override
        public int compareTo(Object o) {
            if (start != ((Pair)o).start)  return (Integer.compare(start, ((Pair)o).start));
            else return (Integer.compare(((Pair)o).index, index)); // opposite, negative is last
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
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
