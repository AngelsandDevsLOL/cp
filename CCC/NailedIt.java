package CCC;

import java.io.*;
import java.util.*;

public class NailedIt {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main (String args[]) throws IOException {
        int n = readInt();
        int[] ar = new int[2001]; // you have ar[i] number of i length wood planks
        for (int i = 0; i < n; i++) {
            ar[readInt()]++;
        }
        int largest = 0;
        int count = 0;
        int[] heights = new int[4001]; // you can create
        for (int i = 2; i < 4000; i++) {

            int x = 1;
            for (int j = i - x; j >= 0; j--) {
                if (x > j) break;
                if (j > 2000) {
                    x = x + (j - 2000);
                    j = 2000;
                }
                if (x == j) {
                    heights[i] = heights[i] + ar[x]/2;
                    break;
                } else {
                    heights[i] = heights[i] + Math.min(ar[x], ar[j]);
                }
                x++;
            }
            if (heights[i] > largest) {
                largest = heights[i];
                count = 1;
            } else if (heights[i] == largest) {
                count++;
            }
        }
        System.out.println(largest + " " + count);
    }
    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(readLine());
        return st.nextToken();
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static int[] convert (String[] in) {
        int[] out = new int[in.length - 1];
        for (int i = 1; i < in.length; i++) out[i - 1] = Integer.parseInt(in[i]);
        return out;
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
