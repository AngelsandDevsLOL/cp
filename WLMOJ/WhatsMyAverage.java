package WLMOJ;

import java.util.*;
import java.io.*;

public class WhatsMyAverage {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main (String[] args) throws IOException {
        int n = readInt(), q = readInt();
        double[] grades = new double[n + 2];
        for (int i = 1; i <= n; i++) {
            grades[i] = readInt();
        }
        int[] percentage = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            int input = readInt();
            percentage[i] += percentage[i - 1] + input;
            grades[i] *= input;
            grades[i] += grades[i - 1];
        }
        for (int i = 0; i < q; i++) {
            int l = readInt(), r = readInt();
            if (percentage[r + 1] == percentage[l]) System.out.println(100);
            else {
                System.out.println((int) Math.round((grades[r + 1] - grades[l]) / (percentage[r + 1] - percentage[l])));
            }
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
