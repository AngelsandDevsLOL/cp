package CCC;

import java.util.*;
import java.io.*;

public class BalancedString {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        String s = readLine();
        int uppercase = 0;
        int lowercase = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (character >= 65 && character <= 90 || character >= 97 && character <= 122) {
                String lower = s.substring(i,i+1).toLowerCase(Locale.ROOT);
                if (lower.equals(s.substring(i,i+1))) {
                    lowercase++;
                } else
                    uppercase++;
            }
        }
        if (uppercase == lowercase) {
            System.out.println("YES");
        } else
            System.out.println("NO");
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