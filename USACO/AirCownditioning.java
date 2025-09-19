package USACO;

import java.io.*;
import java.util.*;

public class AirCownditioning {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = readInt(), p[] = new int[n + 1], t[] = new int[n+1], d[] = new int[n+2], ans = 0;
        for (int i = 1; i <= n; i++) {
            p[i] = readInt();
        }
        for (int i = 1; i <= n; i++) {
            t[i] = readInt();
            d[i] = p[i] - t[i];
        }
        for (int i = 1; i <= n + 1; i++) {
            if (d[i] - d[i-1] > 0) ans += d[i] - d[i-1];
        }
        System.out.println(ans);
    }
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