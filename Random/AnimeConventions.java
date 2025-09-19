package Random;

import java.io.*;
import java.util.*;

public class AnimeConventions {
    static int[] parent;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = readInt();
        int q = readInt();
        parent = new int[n+1];
        Arrays.fill(parent, -1);
        for (int i = 0; i < q; i++) {
            String[] input = readLine().split(" ");
            if (input[0].equals("A")) {
                int p = recursion(Integer.parseInt(input[1]));
                int p2 = recursion(Integer.parseInt(input[2]));
                if (p != p2)parent[p2] = p;
            } else {
                int p = recursion(Integer.parseInt(input[1]));
                int p2 = recursion(Integer.parseInt(input[2]));
                if (p == p2) {
                    System.out.println("Y");
                } else System.out.println("N");
            }
        }
    }
    static int recursion(int x) {
        if (parent[x] < 0) {
            return x;
        }
        return recursion(parent[x]);
    }


    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    static String readLine() throws IOException {
        return br.readLine().trim();
    }
}