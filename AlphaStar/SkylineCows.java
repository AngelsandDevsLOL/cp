package AlphaStar;

import java.util.*;
import java.io.*;

public class SkylineCows {
    public static void main (String[] args) throws IOException {
        int t = readInt();
        for (int i = 0; i < t; i++) {
            int n = readInt(), m = readInt();
            int[] set = new int[n + 1]; // set #
            Arrays.fill(set, -1);
            for (int j = 0; j < m; j++) {
                int x = readInt(), y = readInt();
                int p1 = parent(x, set);
                int p2 = parent(y, set);
                if (p1 != p2) {
                    set[p1] = p2;
                }
            }
            HashMap<Integer, TreeSet<Integer>> hMap = new HashMap<>();
            for (int j = 1; j <= n; j++) {
                int parent = parent(j, set);
                if (hMap.containsKey(parent)) hMap.get(parent).add(j);
                else {
                    TreeSet<Integer> tSet = new TreeSet<>();
                    tSet.add(j);
                    hMap.put(parent, tSet);
                }
            }
            TreeSet<Integer> set1 = hMap.get(parent(1, set));
            TreeSet<Integer> set2 = hMap.get(parent(n, set)); // MEET IN THE MIDDLE
            int[] dif = new int[n + 1];
            Arrays.fill(dif, Integer.MAX_VALUE);
            dif[parent(1, set)] = 0;
            int prev = -1;
            for (int x : set1) {
                if (prev == -1) {
                    prev = 1; continue;
                }
                for (int j = prev + 1; j < x; j++) {
                    int par = parent(j, set);
                    dif[par] = Math.min(Math.min(dif[par], j - prev), x - j);
                }
                prev = x;
            }
            for (int j = prev + 1; j <= n; j++) {
                int par = parent(j, set);
                dif[par] = Math.min(j - prev, dif[par]);
            }
            prev = set2.ceiling(Integer.MIN_VALUE);
            long ans = ( (long)Math.ceil((n - 1) / 2.0) * (long)(Math.ceil((n - 1) / 2.0))) + (long)Math.floor((n - 1) / 2.0) * (long)Math.floor((n - 1) / 2.0);
            for (int j = 1; j <= prev; j++) {
                int par = parent(j, set);
                ans = (long) Math.min(ans, (long)dif[par] * (long)dif[par] + (long)(prev - j) * (long)(prev - j));
            }
            prev = -1;
            for (int x : set2) {
                if (prev == -1) {
                    prev = x; continue;
                }
                for (int j = prev + 1; j < x; j++) {
                    int par = (int) Math.pow(dif[parent(j, set)], 2);
                    ans = (long) Math.min(ans, Math.min(par + (long)(j - x) * (long)(j - x), par + (long)(j - prev) * (long)(j - prev)));
                }
                prev = x;
            }
            System.out.println(ans);
        }
    }
    public static int parent (int x, int[] set) {
        if (set[x] == -1) return x;
        else return set[x] = parent(set[x], set);
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
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
