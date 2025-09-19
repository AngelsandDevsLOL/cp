package LCC;

import java.util.*;
import java.io.*;

public class SpareSolitaire {
    public static int[] pow; // pow(3, exp)
    public static long mod = (long) (1e9 + 7);

    public static void main(String[] args) throws IOException {
        int n = readInt();
        pow = new int[8];
        pow[0] = 1;
        for (int i = 1; i <= 7; i++) {
            pow[i] = 3 * pow[i - 1];
        }
        String input = readLine();
        long[] dp = new long[pow[7]];
        // S = 0, D = 1, C = 2
        StringBuilder f = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            if (input.charAt(i) == 'S') f.append("0");
            else if (input.charAt(i) == 'D') f.append("1");
            else f.append("2");
        }
        dp[0] = 1;
        int find = Integer.parseInt(f.toString(), 3);
        for (int i = 0; i < n; i++) {
            long[] next = new long[pow[7]];
            for (int j = 0; j < pow[7]; j++) {
                // j is the base 10 version
                for (int k = 0; k < 7; k++) { // replace 1 character
                    int cur = j / pow[k] % 3;
                    for (int l = 0; l < 3; l++) {
                        if (l == cur) continue;
                        int nex = j - cur * pow[k] + l * pow[k];
                        next[j] += dp[nex];
                        next[j] %= mod;
                    }
                }
                for (int k = 0; k < 6; k++) {
                    int cur = j / pow[k] % 3;
                    int cur2 = j / pow[k + 1] % 3;
                    if (cur == cur2) continue;
                    int nex = j - cur * pow[k] - cur2 * pow[k + 1] + cur * pow[k + 1] + cur2 * pow[k];
                    next[j] += dp[nex];
                    next[j] %= mod;
                }
            }
            dp = next;
        }
        System.out.println(dp[find]);
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