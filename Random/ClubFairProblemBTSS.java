package Random;

import java.util.*;
import java.io.*;
//https://dmoj.ca/problem/tss17b
public class ClubFairProblemBTSS {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int q = readInt();
        double[] houses = new double[n];
        for (int i = 0; i < n; i++) {
            int x = readInt();
            int y = readInt();
            double doublee = (x*x) + (y*y);
            double radiusFromVolcano = Math.sqrt(doublee);
            houses[i] = radiusFromVolcano;
        }
        Arrays.sort(houses);
        for (int i = 0; i < q; i++) {
            int radius = readInt();
            for (int j = 0; j < houses.length; j++) {
                if (houses[j] > radius) {
                    System.out.println(j);
                    break;
                }
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