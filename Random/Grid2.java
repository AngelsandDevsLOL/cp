package Random;

import java.util.*;
import java.io.*;

public class Grid2 {
    public static int mod = (int) (1e9 + 7);
    public static int[][] ar;
    public static void main (String[] args) throws IOException {
        int h = readInt(), w = readInt(), n = readInt();
        ar = new int[h][w];
        for (int i = 0; i < n; i++) {
            int r = readInt() - 1, c = readInt() - 1;
            ar[r][c] = -1;
        }
        ar[0][0] = 1;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (ar[i][j] != -1) {
                    if (check(i - 1, j) && ar[i - 1][j] != -1) ar[i][j] += ar[i - 1][j];
                    if (check(i, j - 1) && ar[i][j - 1] != -1) ar[i][j] += ar[i][j - 1];
                    ar[i][j] %= mod;
                }
            }
        }
        System.out.println(ar[h - 1][w - 1]);
    }
    public static boolean check (int x, int y) {
        if (x >= 0 && y >= 0) return true;
        return false;
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
