package CCC;

import java.io.*;
import java.util.*;

public class LovelyPhoto {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static long ans = 0;
    public static void main(String[] args) throws IOException {
        int n = readInt();
        String s = readLine();
        List<Integer> g = new ArrayList<>(), h = new ArrayList<>();
        g.add(0);
        h.add(0);
        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i-1) == 'G') g.add(i);
            if (s.charAt(i-1) == 'H') h.add(i);
        }
        g.add(n+1);
        h.add(n+1);
        fun(g); fun(h);
        System.out.println(ans);
    }
    static void fun (List<Integer> first) {
        for (int i = 1; i + 1 < first.size(); i++) {
            int left = first.get(i) - first.get(i-1), right = first.get(i+1) - first.get(i);
            ans += Math.max(right - 2, 0);
            if (left > 1) ans += Math.max(right - 1, 0);
            if (left > 2) ans += (long)(left - 2) * right;
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