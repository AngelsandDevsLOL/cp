package CCC;

import java.util.*;
import java.io.*;

public class CookieSprinkler {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt();
        String[][] array = new String[n][n];
        int q = readInt();
        for (int i = 0; i < q; i++) {
            String[] x = readLine().split(" ");
            if (x[0].equals("1")) {
                int xx = Integer.parseInt(x[1])-1;
                int yy = Integer.parseInt(x[2])-1;
                array[xx][yy] = "1";
            } else {
                int x1 = Integer.parseInt(x[1])-1;
                int y1 = Integer.parseInt(x[2])-1;
                int x2 = Integer.parseInt(x[3])-1;
                int y2 = Integer.parseInt(x[4])-1;
                for (int j = x1; j <= x2; j++) {
                    for (int k = y1; k <= y2; k++) {
                        array[j][k] = array[j][k] + "0";
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String a = array[i][j];
                if (a != null && a.contains("1") && a.contains("0")) {
                    count = count + a.length()-1;
                }
            }
        }
        System.out.println(count);
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