package NoContest;

import java.io.*;
import java.util.*;

public class ExamPrep {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int[] parent;
    public static void main (String[] args) throws IOException {
        int n = readInt(), q = readInt();
        parent = new int[n+1];
        long[] resourcefulness = new long[n + 1];
        Arrays.fill(parent, -1);
        for (int i = 1; i <= n; i++) {
            resourcefulness[i] = readInt();
        }
        for (int i = 0; i < q; i++) {
            int query = readInt();
            if (query == 1) {
                int a = readInt(), b = readInt();
                int p1 = find(a);
                int p2 = find(b);
                if (p1 != p2) {
                    parent[p2] += parent[p1];
                    parent[p1] = p2;
                    resourcefulness[p2] += resourcefulness[p1];
                }
            } else if (query == 2) {
                int a = readInt();
                int p = find(a);
                System.out.println(parent[p] * -1);
            } else {
                int a = readInt();
                int p = find(a);
                System.out.println(resourcefulness[p]);
            }
        }
    }
    public static int find(int num) {
        if (parent[num] < 0) return num;
        parent[num] = find(parent[num]);
        return parent[num];
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