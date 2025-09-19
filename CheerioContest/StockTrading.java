package CheerioContest;

import java.util.*;
import java.io.*;

public class StockTrading {
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int[][] ar = new int[n][2];
        double[][] slope = new double[n][2];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int t = readInt(), p = readInt();
            ar[i][0] = t;
            ar[i][1] = p;
            slope[i][0] = Integer.MIN_VALUE;
            slope[i][1] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                double temp = (p * 1.0 - ar[j][1]) / (t * 1.0 - ar[j][0]);
                if (temp >= slope[j][0]) {
                    slope[j][0] = temp;
                    ans++;
                }
                if (temp <= slope[j][1]) {
                    slope[j][1] = temp;
                    ans++;
                }
                if (slope[j][0] == slope[j][1]) ans--;
            }
        }
        System.out.println(ans);
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

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