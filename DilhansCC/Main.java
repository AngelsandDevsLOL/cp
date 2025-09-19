package DilhansCC;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static long mod = 998244353;
    public static void main(String[] args) throws IOException {
        int n = readInt(), k = readInt();
        int[] input = new int[n];
        int negative = 0;
        boolean possible = true;
        for (int i = 0; i < n; i++) { // only for first subtask
            int a = readInt();
            input[i] = a;
            if (a == -1) negative++;
            if (i != 0 && input[i] != -1 && input[i] < input[i - 1]) possible = false;
        }
        if (!possible) System.out.println(-1);
        else if (negative > n - 2) System.out.println("Infinity");
        else {
            int ind = -1;
            int val = -1;
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (input[i] != -1) { // 1 -1 3
                    if (ind != -1) { // obviously 1 2 3
                        ans = Math.min(ans, (input[i] - val) / (i - ind));
                    }
                    val = input[i];
                    ind = i;
                }
            }
            System.out.println(ans == Integer.MAX_VALUE ? "Infinity" : ans); // shouldn't be inf
        }
    }
    static long pow (long x, long exp){
        if (exp==0) return 1;
        long t = pow(x, exp/2);
        t = t*t %mod;
        if (exp%2 == 0) return t;
        return t*x%mod;
    }
    static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
    static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
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

