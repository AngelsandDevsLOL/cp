package CCC;

import java.util.*;
import java.io.*;

public class CalendarManagement {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int a = readInt();
        int k = readInt();
        TreeMap<Integer, String> tMap = new TreeMap();
        int[] assessment = new int[k];
        for (int i = 0; i < a; i++) {
            String[] x = readLine().split(" ");
            tMap.put(Integer.parseInt(x[0]),x[1]);
        }
        for (int i = 0; i < k; i++) {
            assessment[i] = readInt();
        }
        int count = 0;
        for (int i = 0; i < k; i++) {
            for (int j = assessment[i]; j > count; j--) {
                if (tMap.containsKey(j)) {
                    System.out.println(tMap.get(j));
                }
            }
            count = assessment[i];
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