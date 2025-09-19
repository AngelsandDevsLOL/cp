package CCC;

import java.util.*;
import java.io.*;

public class MimiandBinary3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        String input = readLine();
        TreeMap<Integer, Integer> tMap = new TreeMap<>();
        for (int i = 0; i < input.length(); i++) {

        }
        int q = readInt();
        for (int i = 0; i < q; i++) {
            int x = readInt()-1;
            int y = readInt();
            int z = readInt();
            // find the index after x for the the yth z

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