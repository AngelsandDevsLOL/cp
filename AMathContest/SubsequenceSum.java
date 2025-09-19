package AMathContest;

import java.io.*;
import java.util.*;

public class SubsequenceSum {
    public static int summ = 0;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            //ar[i] = readInt();
        }
        for (int i = 0; i < n; i++) {
            toAddorNottoAdd(ar, 1, ar[i]);
        }
        System.out.println(summ);
    }
    static void toAddorNottoAdd(int[] ar, int x, int sum) {
        if (x == ar.length) {
            return;
        }
        toAddorNottoAdd(ar, x+1, sum + ar[x]);
        toAddorNottoAdd(ar, x+1, sum);
        summ = summ + sum;
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