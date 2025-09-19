package CCC;

import java.util.*;
import java.io.*;

public class FrisbeeGolf {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        long input = readLong();
        long a = input/1000;
        input = input - a*1000;
        long b = input/500;
        input = input - b*500;
        long c = input/100;
        input = input - c*100;
        long d = input/50;
        input = input - d*50;
        long e = input/10;
        input = input - e*10;
        long f = input/5;
        input = input - f*5;
        long g = input/1;
        input = input - g*1;
        System.out.println(g + " " + f+ " " +e+ " " +d+ " " +c+ " " +b+ " " +a);

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