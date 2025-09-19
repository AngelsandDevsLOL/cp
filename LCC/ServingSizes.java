package LCC;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ServingSizes {
    public static boolean[] ar;
    public static int[] arr;
    public static int m;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = readInt();
        m = readInt();
        arr = new int[n];
        ar = new boolean[m + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = readInt();
        }
        Arrays.sort(arr);
        int count = 0;
        recursion(0, 0);
        for (int i = 0; i < ar.length; i++) {
            if (ar[i]) count++;
        }
        System.out.println(count);
    }

    public static void recursion(int cur, int sum) {
        if (cur >= arr.length) return;
        recursion(cur + 1, sum);
        sum += arr[cur];
        if (sum > m) {
            return;
        }
        ar[sum] = true;

        recursion(cur + 1, sum);
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