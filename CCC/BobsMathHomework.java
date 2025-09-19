package CCC;

import java.util.*;
import java.io.*;

public class BobsMathHomework {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        long a = readLong();
        long a2 = 2 * a;
        long half = a / 2;

        int count = 1;
        for (long n = 2; n <= half; n++) {
            if (a2 % n == 0) {
                long x = a2 / n - n + 1;
                if (x <= 0) {
                    break;
                }
                if (x % 2 == 0) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

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