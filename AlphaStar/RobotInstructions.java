package AlphaStar;

import java.util.*;
import java.io.*;

public class RobotInstructions {
    public static int n;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static void main (String[] args) throws IOException {
        n = readInt();
        int x = readInt(), y = readInt();
        int[][] ar = new int[n / 2][2];
        for (int i = 0; i < n / 2; i++) {
            int x1 = readInt(), y1 = readInt();
            ar[i][0] = x1; ar[i][1] = y1;
        }
        HashMap<Pair, int[]> h1 = new HashMap<>();
        int[] temp = new int[n / 2 + 1];
        temp[0] = 1;
        h1.put(new Pair(0, 0), temp);
        method1(ar, 0, h1, 0, 0, 1);
        int[][] ar2 = new int[(int)Math.ceil(n / 2.0)][2];
        for (int i = 0; i < ar2.length; i++) {
            int x1 = readInt(), y1 = readInt();
            ar2[i][0] = x1; ar2[i][1] = y1;
        }
        HashMap<Pair, int[]> h2 = new HashMap<>();
        method1(ar2, 0, h2, 0, 0, 1);
        int[] newTemp = new int[n / 2 + 1];
        newTemp[0] = 1;
        h2.put(new Pair(0, 0), newTemp);
        long[] ans = new long[n + 1];
        for (Pair p : h1.keySet()) {
            if (h2.containsKey(new Pair(x - p.x, y - p.y))) {
                int[] array1 = h1.get(p);
                int[] array2 = h2.get(new Pair(x - p.x, y - p.y));
                for (int i = 0; i <= n / 2; i++) {
                    for (int j = 0; j <= Math.ceil(n / 2.0); j++) {
                        ans[i + j] += (long) array1[i] * array2[j];
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.println(ans[i]);
        }
    }
    public static void method1 (int[][] ar, int ind, HashMap<Pair, int[]> ans, int x, int y, int k) {
        if (ind == ar.length) {
            return;
        }
        method1(ar, ind + 1, ans, x, y, k); // to not choose
        if (ans.containsKey(new Pair(x + ar[ind][0], y + ar[ind][1]))) {
            ans.get(new Pair(x + ar[ind][0], y + ar[ind][1]))[k]++;
        } else {
            int[] temp = new int[ar.length + 1];
            temp[k]++;
            ans.put(new Pair(x + ar[ind][0], y + ar[ind][1]), temp);
        }
        method1(ar, ind + 1, ans, x + ar[ind][0], y + ar[ind][1], k + 1); // to choose
    }
    public static class Pair implements Comparator {
        int x;
        int y;

        public Pair(int xx, int yy) {
            x = xx;
            y = yy;
        }

        @Override
        public int compare(Object o1, Object o2) {
            Pair a = (Pair) o1;
            Pair b = (Pair) o2;
            if (a.x == b.x && a.y == b.y) return 0;
            else if (a.x == b.x) return Integer.compare(a.y, b.y);
            return Integer.compare(a.x, b.x);
        }

        @Override
        public boolean equals(Object obj) {
            Pair a = (Pair) obj;
            if (a.x == x && a.y == y) return true;
            return false;
        }
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    public static String next () throws IOException {
        while (st == null || ! st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    public static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
}
