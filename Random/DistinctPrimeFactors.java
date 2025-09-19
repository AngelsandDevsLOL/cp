package Random;

import java.io.*;
import java.util.StringTokenizer;

public class DistinctPrimeFactors {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int a = readInt();
        int b = readInt();
        for (int i = a; i <= b; i++) {
            System.out.println(numbers(i));
        }
    }
    static int numbers(int number) {
        int count = 0;
        final int numberr = number;
        for (int i = 2; i <= numberr / 2 + 1; ++i) {
            boolean bool = false;
            while (number % i == 0) {
                bool = true;
                number = number / i;
            }
            if (bool) {
                count++;
            }
        }
        if (number != 1) {
            count++;
        }
        return count;
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