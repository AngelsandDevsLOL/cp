package CCC;

import java.util.*;
import java.io.*;

public class IU {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int count = 0;
        String input = readLine();
        String x = input.substring(0,2);
        while ((x.equals("IU"))) {
            input = input.substring(2);
            if (input.length()!=0) {
                x = input.substring(0, 2);
            } else
                break;
        }
        while (input.length() != 0) {
            if (input.substring(0,1).equals("U")) {
                int index = input.indexOf("I");
                count = count + index;
                input = input.substring(1,index) + input.substring(index+1);
            } else if (input.length() != 0 && input.substring(0,1).equals("I")) {
                int index = input.indexOf("U");
                count = count + index;
                input = input.substring(1,index) + input.substring(index+1);
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