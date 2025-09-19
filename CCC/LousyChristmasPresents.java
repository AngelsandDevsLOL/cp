package CCC;

import java.util.*;
import java.io.*;

public class LousyChristmasPresents {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt();
        int m = readInt();
        String[] string = readLine().split(" ");
        ArrayList<Integer> aList = new ArrayList();
        for (int i = 0; i < n; i++) {
            aList.add(Integer.parseInt(string[i]));
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            int a = (readInt());
            int b = (readInt());
            int po1 = aList.indexOf(a);
            int po2 = aList.lastIndexOf(b);
            if (po2-po1+1 > count) {
                count = po2-po1+1;
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