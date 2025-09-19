package USACO;

import java.util.*;
import java.io.*;

public class APieForAPie {
    public static void main (String[] args) throws IOException {
        int n = readInt(), d = readInt();
        int[][] bessie = new int[n][4]; // [i][3] is the answer
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int x = readInt(), y = readInt();
            bessie[i][0] = x; bessie[i][1] = y; bessie[i][2] = i;
        }
        int[][] elsie = new int[n][4];
        for (int i = 0; i < n; i++) {
            int x = readInt(), y = readInt();
            elsie[i][0] = y; elsie[i][1] = x; elsie[i][2] = i;
        }
        Arrays.sort(bessie, (x, y) -> Integer.compare(x[1], y[1]));
        Arrays.sort(elsie, (x, y) -> Integer.compare(x[1], y[1]));
        for (int i = 0; i < n; i++) {
            if (bessie[i][1] == 0) {q.add(i);q.add(0); bessie[i][3] = 1;}
            if (elsie[i][1] == 0) {q.add(i); q.add(1); elsie[i][3] = 1;}
        }
        while (!q.isEmpty()) {
            int ind = q.poll(), cow = q.poll(); // bessie -> elsie (0)
            if (cow == 0) { // besise !
                int left = bsearch(Math.max(bessie[ind][0] - d, 0), elsie, 0, n - 1);
                int i;
                for (i = left; i < n; i++) {
                    if (elsie[i][1] <= bessie[ind][0] && elsie[i][1] >= Math.max(bessie[ind][0] - d, 0)) {
                        if (elsie[i][3] == 0) {
                            elsie[i][3] = bessie[ind][3] + 1;
                            q.add(i);
                            q.add(1);
                        }
                    } else break;
                }
            } else {
                int left = bsearch(Math.max(elsie[ind][0] - d, 0), bessie, 0, n - 1);
                int i;
                for (i = left; i < n; i++) {
                    if (bessie[i][1] <= elsie[ind][0] && bessie[i][1] >= Math.max(elsie[ind][0] - d, 0)) {
                        if (bessie[i][3] == 0) {
                            bessie[i][3] = elsie[ind][3] + 1;
                            q.add(i);
                            q.add(0);
                        }
                    } else break;
                }
            }
        }
        Arrays.sort(bessie, (x, y) -> Integer.compare(x[2], y[2]));
        for (int i = 0; i < n; i++) {
            System.out.println(bessie[i][3] == 0 ? -1 : bessie[i][3]);
        }
    }
    public static int bsearch (int x, int[][] ar, int low, int high) {
        int ans = high;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (ar[mid][1] >= x) {
                high = mid - 1;
                ans = mid;
            } else {
                low = mid + 1;
            }
        }
        return ans;
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
