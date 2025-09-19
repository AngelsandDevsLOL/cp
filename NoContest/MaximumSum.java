package NoContest;

import java.io.*;
import java.util.*;

public class MaximumSum {
    public static int[] dis;
    public static int[] memo;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = readInt();
        memo = new int[n];
        dis = new int[n];
        Arrays.fill(memo, -1);
        for (int i = 0; i < n; i++) {
            dis[i] = readInt();
        }
        memo[0] = dis[0];
        method(n - 1);
        if (n > 1) {
            method(n - 2);
            System.out.println(Math.max(memo[n-1], memo[n-2]));
        } else
        System.out.println(memo[n - 1]);
    }
    public static void method(int x) {
        if (memo[x] != -1) return;
        int num = 0;
        if (x - 2 >= 0) {
            if (memo[x - 2] == -1) method(x - 2);
            num = memo[x-2];
        }
        if (x - 3 >= 0) {
            if (memo[x - 3] == -1) method(x - 3);
            num = Math.max(num, memo[x - 3]);
        }
        memo[x] = num + dis[x];
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