package NoContest;

import java.util.*;
import java.io.*;

public class TheCakeIsADessert {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main (String[] args) throws IOException{
        int n = readInt(), m = readInt(), k = readInt();
        long[][] ar = new long[m + 2][n + 2];
        for (int i = 0; i < k; i++) {
            int x = readInt(), y = readInt(), X = readInt(), Y = readInt();
            ar[y][x]++;
            ar[Y + 1][x]--;
            ar[y][X + 1]--;
            ar[Y + 1][X + 1]++;
        }
        for (int i = 1; i <= m; i++) {
            ar[i][1] += ar[i - 1][1];
        }
        for (int i = 1; i <= n; i++) {
            ar[1][i] += ar[1][i - 1];
        }
        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                ar[i][j] += ar[i - 1][j] + ar[i][j - 1] - ar[i - 1][j - 1];
            }
        }
        for (int i = 1; i <= m; i++) {
            ar[i][1] += ar[i - 1][1];
        }
        for (int i = 1; i <= n; i++) {
            ar[1][i] += ar[1][i - 1];
        }
        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                ar[i][j] += ar[i - 1][j] + ar[i][j - 1] - ar[i - 1][j - 1];
            }
        }
        int q = readInt();
        for (int i = 0; i < q; i++) {
            int a = readInt(), b = readInt(), c = readInt(), d = readInt();
            System.out.println(ar[d][c] - ar[d][a - 1] - ar[b - 1][c] + ar[b - 1][a - 1]);
        }
    }
    static String next () throws IOException {
        while (st == null || ! st.hasMoreTokens())
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
