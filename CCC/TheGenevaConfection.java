package CCC;

import java.io.*;
import java.util.*;

public class TheGenevaConfection {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int t = readInt();
        for (int i = 0; i < t; i++) {
            Stack<Integer> branch = new Stack<>();
            Stack<Integer> top = new Stack<>();
            int n = readInt();
            for (int j = 0; j < n; j++) {
                top.push(readInt());
            }
            int x = 1;
            while (x <= n) {
                if (top.size() > 0 && top.peek() == x) {
                    top.pop();
                    x++;
                } else if (branch.size() > 0 && branch.peek() == x) {
                    branch.pop();
                    x++;
                } else {
                    if (top.size() == 0 || branch.size() > 0 && top.peek() > branch.peek()) {
                        break;
                    }
                    branch.push(top.peek());
                    top.pop();
                }
            }
            if (x > n) {
                System.out.println("Y");
            } else {
                System.out.println("N");
            }
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