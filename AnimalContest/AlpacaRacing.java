package AnimalContest;

import java.util.*;
import java.io.*;
public class AlpacaRacing {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = readInt();
        long d = readLong();
        int k = readInt();
        int x = readInt();
        long[] alpacas = new long[n];
        for (int i = 0; i < n; i++) {
            alpacas[i] = readLong();
        }
        long myAlpaca = readLong();
        for (int i = 0; i < k; i++) {
            Arrays.sort(alpacas);
            if (alpacas[n-1] < myAlpaca) break;
            alpacas[n-1] = device(alpacas[n-1], x);
        }
        Arrays.sort(alpacas);
        if (alpacas[n-1] >= myAlpaca){
            System.out.println("NO");
        } else
            System.out.println("YES");
    }
    public static long device(long speed, int x){
        double newSpeed = speed * ((100.0-x)/100);
        long speedd = (long) Math.floor(newSpeed);
        return speedd;
    }
    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(readLine());
        return st.nextToken();
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static int[] convert (String[] in) {
        int[] out = new int[in.length - 1];
        for (int i = 1; i < in.length; i++) out[i - 1] = Integer.parseInt(in[i]);
        return out;
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