package CCC;

import java.util.*;
import java.io.*;

public class DamageOutput {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = readInt();
        long m = readLong();
        long[] arra = new long[n];
        for (int i = 0; i < n; i++) {
            arra[i] = readLong();
        }
        long sum = 0;
        int num = 0;
        long smallest = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            sum = 0;
            num = 0;
            for (int j = i; j < n; j++) {
                sum = sum + arra[j];
                num++;
                if (sum >= m) {
                    break;
                }
            }
            if (num < smallest && sum >= m) {
                smallest = num;
            }
        }
        if (smallest == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else
            System.out.println(smallest);
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