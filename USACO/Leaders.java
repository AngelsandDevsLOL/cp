package USACO;

import java.io.*;
import java.util.*;

public class Leaders {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = readInt();
        String input = readLine();
        int lastg = input.lastIndexOf("G");
        int firstg = input.indexOf("G");
        int lasth = input.lastIndexOf("H");
        int firsth = input.indexOf("H");
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = readInt();
        }
        int h1 = -1;
        if (ar[firsth] >= lasth) {
            h1 = firsth;
        }
        int g1 = -1;
        if (ar[firstg] >= lastg) {
            g1 = firstg;
        }
        int count = 0;
        for (int i = 0; i < h1; i++) {
            if ((input.charAt(i) == 'G' && ar[i] > h1) || i == g1) {
                count++;
            }
        }
        for (int i = 0; i < g1; i++) {
            if ((input.charAt(i) == 'H' && ar[i] > g1) || i == h1) {
                count++;
            }
        }
        System.out.println(count);
    }

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