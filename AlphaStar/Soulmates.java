package AlphaStar;

import java.io.*;
import java.util.*;

public class Soulmates {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        long n = readLong();
        for (long i = 0; i < n; i++) {
            long x = readLong(), y = readLong();
            System.out.println(solve(x, y, true));
        }
    }
    public static long solve (long x, long y, boolean bool) {
        if (x == y) return 0;
        if (x <= y) {
            if (!bool) return solve(y, x, true);
            return Math.min(y - x, solve(y, x, false));
        }
        if (!bool) {
            long dif = x - y;
            if (x % 2== 0) return Math.min(1 + solve(x / 2, y, false), dif);
            else return Math.min(2 + solve((x - 1) / 2, y, false), dif);
        } else {
            if (x % 2== 0) return 1 + solve(x / 2, y, true);
            else return 2 + solve((x + 1) / 2, y, true);
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
