package AnimalContest;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MonkeyMarket {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int x = readInt();
        int[] ar = new int[x];
        for (int i = 0; i < x; i++) {
            ar[i] = readInt();
        }
        Arrays.sort(ar);
        StringBuilder s = new StringBuilder();
        for (int i = 0; i * 2 < x; i++) {
            if (i != x - i - 1) {
                s.append(ar[i] + " " + ar[x - i - 1] + " ");
            } else {
                s.append(ar[i] + " ");
            }
        }
        System.out.println(s.substring(0, s.length()-1));
        for (int i = 0; i < x; i++) {
            if (i == x - 1 && i % 2 == 0) {
                System.out.print("E");
            } else if (i % 2 == 0) {
                System.out.print("B");
            } else {
                System.out.print("S");
            }
        }
        System.out.println();
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
