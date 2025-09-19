package LCC;

import java.util.*;
import java.io.*;

public class MinMaxing2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main (String[] args) throws IOException {
        int n = readInt(), m = readInt();
        long sum = 0;
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = readInt();
            sum += input[i];
        }
        Arrays.sort(input);
        long ans1 = sum;
        long ans2 = sum;
        for (int i = 0; i < n / m; i++) { // loop through the # of groups = total number of people / number of people per group
            ans1 -= input[i]; // decrease by the (n / m)-th smallest values
            ans2 -= input[i * m]; // decrease by the smallest per group
        }
        System.out.println(ans1);
        System.out.println(ans2);
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