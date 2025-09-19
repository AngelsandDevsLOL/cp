package Arcadia;

import java.util.*;
import java.io.*;

public class Alternato {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt();
        int[] ar = new int[n];
        ar[0] = readInt();
        int count = 0;
        int pattern = 0;
        for (int i = 1; i < n && count < 2; i++) {
            int num = readInt();
            ar[i] = num;
            if (ar[i] - ar[i - 1] < 0) {
                if (pattern == -1) {
                    count = 2;
                }
                pattern = -1;
            } else if (ar[i] - ar[i - 1] > 0) {
                if (pattern == 1) {
                    count = 2;
                }
                pattern = 1;
            } else {
                if (pattern == -1) {
                    ar[i]++;
                    count++;
                    pattern = 1;
                } else if (pattern == 1) {
                    ar[i]--;
                    count++;
                    pattern = -1;
                } else {
                    i++;
                    count++;
                    if (i != n) {
                        ar[i] = readInt();
                        if (ar[i] - ar[i - 1] > 0) pattern = 1;
                        else if (ar[i] - ar[i - 1] < 0) pattern = -1;
                        else pattern = 0;
                    }
                }
            }
        }
        if (count == 2) System.out.println(-1);
        else {
            System.out.println(count); // either 0 or 1
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