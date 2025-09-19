package CCC.Senior;

import java.util.*;
import java.io.*;

public class PrettyAveragePrimes {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int testCases = readInt();
        for (int i = 0; i < testCases; i++) {
            int x = readInt() * 2;
            for (int j = 3; j <= x - 3; j = j + 2) {
                if (isPrime(j) && isPrime(x - j)) {
                    System.out.println(j + " " + (x - j));
                    break;
                }
            }
        }
    }
    static boolean isPrime(int n) {
        if(n < 2) return false;
        for(int i=2; i*i <= n; i++) {
            if(n % i == 0) return false;
        }
        return true;
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