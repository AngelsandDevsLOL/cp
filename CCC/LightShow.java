package CCC;

import java.util.*;
import java.io.*;

public class LightShow {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt();
        String[][] array = new String[n][n];
        for (int i = 0; i < 4; i++) {
            String input = readLine();
            for (int j = 0; j < n; j++) {
                String colour = input.substring(j,j+1);
                if (i == 1 || i == 3) {
                    for (int k = 0; k < n; k++) {
                        array[j][k] = array[j][k] + colour;
                    }
                } else if (i == 2 || i == 0) {
                    for (int k = 0; k < n; k++) {
                        array[k][j] = array[k][j] + colour;
                    }
                }
            }
        }
        int gold = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String x = array[i][j];
                if (x.contains("G") && x.contains("B") && x.contains("R")) {
                    gold++;
                }
            }
        }
        System.out.println(gold);
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