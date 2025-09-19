package CCC;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt();
        HashSet<Integer> hSet = new HashSet<>();
        hSet.add(n);
        int[] array = new int[n];
        array[0] = n;
        for (int i = 1; i < n; i++) {
            int x = i + array[i-1];
            if (!isPrime(x)) {
                array[i] = i;
            }
        }
        if (array[array.length-1] == 0) {
            System.out.println(-1);
        } else
            System.out.println(array[array.length-1]);
    }
    static boolean isPrime (int x) {
        boolean bool = true;
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                bool = false;
                break;
            }
        }
        if (bool) {
            return true;
        } else
            return false;
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