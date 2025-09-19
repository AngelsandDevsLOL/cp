package AnimalContest;

import java.util.*;
import java.io.*;

public class LavishLights {
    public static void main(String[] args) throws IOException {
        int n = readInt(), q = readInt();
        long[] lcm = new long[n + 1];
        lcm[0] = 1;
        int i;
        for (i = 1; i <= n; i++) {
            int a = readInt();
            lcm[i] = lcm[i - 1] * a / gcd(Math.min(lcm[i - 1], a), Math.max(lcm[i - 1], a));
            if (lcm[i] > 1e9) {lcm[i] = -1; i++; break;}
        }
        for (; i <= n; i++) {
            lcm[i] = -1;
            readInt();
        }
        for (int j = 0; j < q; j++) {
            int t = readInt();
            if (t == 0) System.out.println(-1);
            else if (lcm[n] != -1 && t % lcm[n] == 0) System.out.println(-1);
            else System.out.println(bsearch(1, i, lcm, t) + 1);
        }
    }

    public static long gcd(long a, long b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }

    public static int bsearch(int l, int r, long[] lcm, int find) {
        int ans = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (lcm[mid] == -1) {
                r = mid - 1; continue;
            }
            if (find % lcm[mid] == 0) {
                ans = mid;
                l = mid + 1;
            } else r = mid - 1;
        }
        return ans;
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