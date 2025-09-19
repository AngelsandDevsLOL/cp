package CCC.Senior;

import java.util.*;
import java.io.*;

public class TopYodeller {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int k = readInt();
        int s = readInt();
        int[][] contest = new int[101][101];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) {
                    contest[i][j] += contest[i-1][j] + s;
                } else {
                    contest[i][j] = s;
                }
            }
        }
        int largest = 0;
        int index = 0;
        int[] cone = contest[k-1];
        for (int i = 0; i < n; i++) {
            if (largest < cone[i]) {
                largest = cone[i];
                index = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (largest == contest[k-1][i]) {
                int x = worstRank(i, k, n, contest);
                System.out.println("Yodeller " + (i+1) + " is the TopYodeller: score " + largest + ", worst rank " + x);
            }
        }
    }
    static int worstRank(int c, int k, int n, int[][] contest) {
        int worst = -1;
        for (int i = 0; i < k; i++) {
            int r = 1;
            for (int j = 0; j < n; j++) {
                if (contest[i][j] > contest[i][c]) {
                    r++;
                }
            }
            worst = Math.max(r, worst);
        }
        return worst;
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