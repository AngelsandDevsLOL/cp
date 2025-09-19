package CCC;

import java.io.*;
import java.util.*;

public class Boxes {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static String[] s;
    static int[] sizes;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        s = new String[N]; sizes = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken(), b = st.nextToken(), c = st.nextToken();
            s[i] = a + " " + b + " " + c;
            sizes[i] = Integer.parseInt(a) * Integer.parseInt(b) * Integer.parseInt(c);
        }
        int cases = Integer.parseInt(br.readLine());
        for (int i = 0; i < cases; i++) {
            boolean found = false;
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken() + " " + st.nextToken() + " " + st.nextToken();
            int ans = Integer.MAX_VALUE;
            for (int j = 0; j < s.length; j++) {
                if (check(temp, s[j])){
                    ans = Math.min(sizes[j], ans);
                    found = true;
                }
            }
            if (!found) System.out.println("Item does not fit.");
            else System.out.println(ans);
        }
    }
    static boolean check(String a, String b){
        String [] first = a.split(" ");
        String [] second = b.split(" ");
        int [] temp1 = new int[3]; int [] temp2 = new int[3];
        for (int i = 0; i < 3; i++) {
            temp1[i] = Integer.parseInt(first[i]);
            temp2[i] = Integer.parseInt(second[i]);
        }
        Arrays.sort(temp1); Arrays.sort(temp2);
        for (int i = 0; i < 3; i++) {
            if (temp1[i]>temp2[i]) return false;
        }
        return true;
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