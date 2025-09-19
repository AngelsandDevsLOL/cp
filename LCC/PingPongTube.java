package LCC;

import java.io.*;
import java.util.*;

public class PingPongTube {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main (String[] args) throws IOException {        Scanner scanner = new Scanner(System.in);
        int n = readInt();
        StringBuilder string = new StringBuilder();
        StringBuilder string2 = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] input = readLine().split(" ");
            if (input[0].equals("R")) {
                string.append(input[1]);
            } else {
                string2.append(input[1]);

            }
        }
        string2.reverse();
        String str = String.valueOf(string2) + String.valueOf(string);
        int count = 0;
        for (int i = 1; i < str.length(); i++) {
            if (!str.substring(i,i+1).equals(str.substring(i-1,i))) {
                count++;
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
