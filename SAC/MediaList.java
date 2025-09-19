package SAC;

import java.util.*;
import java.io.*;

public class MediaList {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt();
        int q = readInt();
        Set<String>[] set = new Set[n];
        for (int i = 0; i < q; i++) {
            String[] input = readLine().split(" ");
            int first = Integer.parseInt(input[0]);
            int second = Integer.parseInt(input[1]);
            if (first == 1) {
                if (set[second - 1] != null && set[second - 1].contains(input[2])) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else {
                if (set[second - 1] == null) {
                    set[second - 1] = new HashSet();
                }
                set[second - 1].add(input[2]);
            }
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