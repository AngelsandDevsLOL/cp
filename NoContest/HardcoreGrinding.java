package NoContest;

import java.io.*;
import java.util.StringTokenizer;

public class HardcoreGrinding {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String args[]) throws IOException {
        int n = readInt();
        int max = 0;
        int[] ar = new int[10000001];
        for (int i = 0; i < n; i++) {
            int s = readInt();
            int f = readInt();
            ar[s]++;
            ar[f]--;
        }
        int temp = 0;
        for (int i = 1; i < ar.length; i++) {
            ar[i] = ar[i-1] + ar[i];
            if (ar[i] > temp) {
                temp = ar[i];
            }
        }
        System.out.println(temp);
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