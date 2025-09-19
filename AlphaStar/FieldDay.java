package AlphaStar;

import java.io.*;
import java.util.*;

public class FieldDay {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int c = readInt(), n = readInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            String input = readLine();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < c; j++) {
                if (input.charAt(j) == 'G') {
                    sb.append('1');
                } else sb.append('0');
            }
            ar[i] = Integer.parseInt(sb.toString(), 2);
        }
        for (int i = 0; i < n; i++) {
            int min = 0;
            for (int j = 0; j < n; j++) {
                min = Math.max(Integer.bitCount(ar[i] ^ ar[j]), min);
                if (min == c) break;
            }
            System.out.println(min);
        }
    }

    static String next () throws IOException {
        while (st == null || ! st.hasMoreTokens())
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
