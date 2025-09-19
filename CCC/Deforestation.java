package CCC;

import java.io.*;
import java.util.StringTokenizer;

public class Deforestation {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt();
        int[] tree = new int[n];
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                tree[i] = readInt() + tree[i-1];
            } else
                tree[i] = readInt();
        }
        int q = readInt();
        for (int i = 0; i < q; i++) {
            int a = readInt();
            int b = readInt();
            if (a != 0){
                System.out.println(tree[b] - tree[a-1]);
            } else
            System.out.println(tree[b] - 0);
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
