package DMOPC;

import java.io.*;
import java.util.*;

public class WishUponAStar {
    public static int[] p;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main (String[] args) throws IOException {
        int n = readInt();
        int m = readInt();
        p = new int[n + 1];
        Arrays.fill(p, -1);
        int count = 0;
        for (int i = 0; i < m; i++) {
            int a = readInt();
            int b = readInt();
            int p1 = parent(a);
            int p2 = parent(b);
            if (p1 == p2) {
                count++;
                if (count > 1) break;
            } else {
                p[p2] = p1;
            }
        }
        if (count < 2) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
    public static int parent(int x) {
        if (p[x] != -1) {
            return parent(p[x]);
        } else {
            return x;
        }
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