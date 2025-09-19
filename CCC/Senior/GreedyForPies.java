package CCC.Senior;

import java.util.*;
import java.io.*;

public class GreedyForPies {
    static int[][][][] dp; // [order of a[]], [left pointer] [right pointer]
    static int[] a, b;
    static short n;
    public static void main (String[] args) throws IOException {
        n = readShort();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            int input = readInt();
            a[i] = input;
        }
        short m = readShort();
        dp = new int[n + 1][m + 2][m + 2][2];
        b = new int[m + 1];
        for (int i = 0; i < m; i++) {
            int input = readInt();
            b[i] = input;
        }
        Arrays.sort(b);
        System.out.println(recur(0, 1, m,  true));
    }
    public static int recur (int ind, int l, int r, boolean can) {
        if (dp[ind][l][r][can ? 1 : 0] != 0) return dp[ind][l][r][can ? 1 : 0];
        int ans = 0;
        if (ind < n) {
            if (can) {
                ans = a[ind] + recur(ind + 1, l, r, false);
            }
            ans = Math.max(ans, recur(ind + 1, l, r, true));
        }
        if (l <= r) {
            if (can) {
                ans = Math.max(ans, b[r] + recur(ind, l, r - 1, false));
            }
            ans = Math.max(ans, recur(ind, l + 1, r, true));
        }
      // System.out.println(ind + " " + l + " " + r + " " + can + " " + ans);
        return dp[ind][l][r][can ? 1 : 0] = ans;
    }
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer st;
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
        static short readShort () throws IOException {
            return Short.parseShort(next());
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
