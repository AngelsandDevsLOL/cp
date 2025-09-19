package JOI;

import java.util.*;
import java.io.*;

public class FoehnPhenomena {
    public static void main(String[] args) throws IOException {
        int n = readInt(), q = readInt(), s = -readInt(), t = -readInt();
        int[] ar = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ar[i] = readInt();
        }
        long ans = 0;
        long[] diff = new long[n];
        for (int i = 1; i <= n; i++) {
            diff[i - 1] = ar[i] - ar[i - 1];
            ans += diff[i - 1] * (diff[i - 1] > 0 ? s : t);
        }
        for (int i = 0; i < q; i++) {
            int x = readInt(), y = readInt(), dif = readInt();
            ans -= diff[x - 1] * (diff[x - 1] > 0 ? s : t);
            diff[x - 1] += dif;
            ans += diff[x - 1] * (diff[x - 1] > 0 ? s : t);

            if (y == n) {
                System.out.println(ans);
                continue;
            }
            ans -= diff[y] * (diff[y] > 0 ? s : t);
            diff[y] -= dif;
            ans += diff[y] * (diff[y] > 0 ? s : t);
            System.out.println(ans);
        }
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
