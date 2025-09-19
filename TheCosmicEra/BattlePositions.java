package TheCosmicEra;

import java.util.*;
import java.io.*;

public class BattlePositions {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int i = readInt();
        int n = readInt();
        int j = readInt();
        int[] stations = new int[i];
        for (int k = 0; k < j; k++) {
            int xi = readInt();
            int xf = readInt();
            int soldiers = readInt();
            for (int l = xi-1; l < xf; l++) {
                stations[l] = stations[l] + soldiers;
            }
        }
        int u = 0;
        for (int k = 0; k < i; k++) {
            if (stations[k] < n) {
                u++;
            }
        }
        System.out.println(u);
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