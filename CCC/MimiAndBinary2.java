package CCC;

import java.util.*;
import java.io.*;

public class MimiAndBinary2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        String s = readLine();
        int q = readInt();
        ArrayList<Integer> zero = new ArrayList<>();
        ArrayList<Integer> one = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int x = Integer.valueOf(s.substring(i, i + 1));
            if (x == 0) {
                zero.add(i);
            } else {
                one.add(i);
            }
        }
        for (int i = 0; i < q; i++) {
            int x = readInt() - 1;
            int y = readInt();
            int z = readInt();
            if (z == 0) {
                int b = binarySearch(zero, 0, zero.size() - 1, x);
                if (b + y < zero.size()) {
                    System.out.println(zero.get(b + y) + 1);
                } else {
                    System.out.println(-1);
                }
            } else {
                int b = binarySearch(one, 0, one.size() - 1, x);
                if (b + y < one.size()) {
                    System.out.println(one.get(b + y) + 1);
                } else {
                    System.out.println(-1);
                }
            }
        }
    }
    public static int binarySearch(ArrayList<Integer> a, int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (x == a.get(mid)) {
                return mid - 1;
            }
            if (x > a.get(mid)) {
                return binarySearch(a, mid + 1, r, x);
            }
            return binarySearch(a, l, mid - 1, x);
        }
        return r;
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