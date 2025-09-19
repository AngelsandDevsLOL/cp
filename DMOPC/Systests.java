package DMOPC;

import java.io.*;
import java.util.*;

public class Systests {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int b = readInt();
        long sum = 0;
        HashSet<String> hSet = new HashSet<>();
        TreeSet<Integer> tSet = new TreeSet();
        for (int i = 0; i < b; i++) {
            String input = readLine() + " " + i;
            hSet.add(input);
        }
        int f = readInt();
        for (int i = 0; i < f; i++) {
            tSet.add(readInt());
        }
        for (String string : hSet) {
            String[] ar = string.split(" ");
            sum = Long.parseLong(sum + ar[2]);
            if (tSet.ceiling(Integer.valueOf(ar[0])) != null && tSet.ceiling(Integer.valueOf(ar[0])) < Integer.parseInt(ar[1])) {
                sum = sum - Long.parseLong(ar[2]);
            }
        }
        System.out.println(sum);
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

