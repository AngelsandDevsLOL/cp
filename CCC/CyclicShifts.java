package CCC;

import java.util.*;
import java.io.*;

public class CyclicShifts {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        String input = readLine();
        String s = readLine();
        String integer = s;
        boolean bool = true;
        for (int i = 0; i < s.length(); i++) {
            s = integer.substring(1) + integer.substring(0,1);
            if (input.contains(s)) {
                System.out.println("yes");
                bool = false;
                break;
            }
            if (i != s.length()-1){
                integer = s;
            }
        }
        if (bool) {
            System.out.println("no");
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