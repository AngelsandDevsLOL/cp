package CCC;

import java.util.*;
import java.io.*;

public class SwapitySwap {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n =readInt();
        int[] array = new int[n];
        int k = readInt();
        for (int i = 0; i < n; i++) {
            array[i] = i+1;
        }
        int a1 = readInt();
        int a2 = readInt();
        int b1 = readInt();
        int b2 = readInt();
        for (int i = 0; i < k; i++) {
            swap (array, a1, a2);
            swap (array, b1, b2);
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    static void swap (int[] array, int a, int b) {
        int[] arrayy = new int[b-a+1];
        int integer = 0;
        for (int i = a-1; i < b; i++) {
            arrayy[integer] = array[i];
            integer++;
        }
        for (int i = a-1; i < b; i++) {
            array[i] = arrayy[b-i-1];
        }
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