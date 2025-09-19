package CCC;

import java.util.*;
import java.io.*;

public class FarthestHiking {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int m = readInt();
        int n = readInt();
        int u = readInt();
        int f = readInt();
        int d = readInt();
        int count = 0;
        String input = readLine();
        int count2 = 0;
        for (int i = 0; i < input.length(); i++) {
            String x = input.substring(i,i+1);
            if (x.equals("u")) {
                if (count + u + d <= m) {
                    count = count + d + u;
                    count2++;
                } else
                    break;
            } else if (x.equals("f")) {
                if (count + f + f <= m) {
                    count = count + f + f;
                    count2++;
                } else
                    break;
            } else if (x.equals("d")) {
                if (count + u + d <= m) {
                    count = count + u + d;
                    count2++;
                } else
                    break;
            }
        }
        System.out.println(count2);
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