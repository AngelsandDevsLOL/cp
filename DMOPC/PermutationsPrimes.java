package DMOPC;

import java.util.*;
import java.io.*;

public class PermutationsPrimes {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = readInt();
        if (n == 1) System.out.println(1);
        else if (n < 5) System.out.println(-1);
        else {
            for (int i = 1; i <= n; i = i+2) {

                if (i != 5) {
                    System.out.print(i + " " );
                }
            }
            System.out.print("5 4");

            for (int i = 2; i <= n; i=i+2) {
                if (i != 4) {
                    System.out.print(" " + i );
                }
            }

        }
    }
    public static boolean isPrime(int x) {
        boolean bool = true;
        if (x > 2 && x % 2 == 0) bool = false;
        for (int i = 3; i <= Math.sqrt(x); i = i + 2) {
            if (x % i == 0) bool = false;
        }
        return bool;
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