package Random;

import java.util.*;
import java.io.*;

public class AvocadoTrees {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int max = 0;
        int n = readInt();
        int q = readInt();
        int h = readInt();
        int[] sum = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int height = readInt();
            int avo = readInt();
            if (height <= h) {
                sum[i] = sum[i - 1] + avo;
            } else {
                sum[i] = sum[i-1];
            }
        }
        for (int i = 0; i < q; i++) {
            int l  = readInt();
            int r = readInt();
            if (max < sum[r] - sum[l-1]) {
                max = sum[r] - sum[l-1];
            }
        }
        System.out.println(max);
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