package TheCosmicEra;

import java.util.*;
import java.io.*;

public class Uneven {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        long a = 1;
        long b = Integer.MAX_VALUE;
        String results = "";
        while (!(results.equals("OK"))) {
            long x = (a + b) / 2;
            System.out.println(x);
            System.out.flush();
            results = readLine();
            if (results.equals("SINKS")) {
                a = x;
            } else if (results.equals("FLOATS")) {
                b = x;
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