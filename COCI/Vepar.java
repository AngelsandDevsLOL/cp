package COCI;

import java.io.*;
import java.util.StringTokenizer;
import java.util.*;

public class Vepar {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int t = readInt();
        ArrayList<Integer> primes = new ArrayList<>();
        boolean[] sieved = new boolean[10000015];
        for (int p = 2; p < 1e7+5; p++) {
            if (!sieved[p]) primes.add(p);
            for (int i = p; i < 1e7+5; i=i+ p) {
                sieved[i] = true;
            }
        }
        for (int i = 0; i < t; i++) {
            int a = readInt() - 1;
            int b = readInt();
            int c = readInt() - 1;
            int d = readInt();
            boolean bool = true;
            for (int p : primes) {
                if (val(p, a) + val(p, d) < val(p,c) + val(p,b)) {
                    bool = false;
                    break;
                }
            }
            if (bool) System.out.println("DA");
            else System.out.println("NE");
        }
    }
    public static int val(int p, int A) {
        if (A == 0) return 0;
        return A/p + val(p, A/p);
    }
    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(readLine());
        return st.nextToken();
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static int[] convert (String[] in) {
        int[] out = new int[in.length - 1];
        for (int i = 1; i < in.length; i++) out[i - 1] = Integer.parseInt(in[i]);
        return out;
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