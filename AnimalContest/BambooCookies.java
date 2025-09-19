package AnimalContest;

import java.util.*;
import java.io.*;

public class BambooCookies {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n =readInt();
        int even = 0;
        int odd = 0;
        HashSet<Integer> hSet = new HashSet<>();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = readInt();
            if (array[i] % 2 == 0) {
                even++;
            } else
                odd++;
        }
        System.out.println((even/2) + (odd/2));
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