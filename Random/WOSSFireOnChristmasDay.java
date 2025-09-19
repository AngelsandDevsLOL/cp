package Random;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class WOSSFireOnChristmasDay {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = readInt(), m = readInt();
        ArrayList<Integer>[] fireExits = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            fireExits[i] = new ArrayList<>();
            fireExits[i].add(n);
            fireExits[i].add(1);
        }
        for (int i = 0; i < m; i++) {
            int p = readInt(), d = readInt();
            for (int j = Math.max(p-d,1); j <= Math.min(p+d,n); j++) {
                fireExits[j].add(p);
            }
        }
        int q = readInt();
        for (int i = 0; i < q; i++) {
            int query = readInt(), position = readInt();
            if (query == 1) {
                ArrayList<Integer> exits = fireExits[position];
                int exit = exits.get(0);
                for (int j = 1; j < exits.size(); j++) {
                    if (Math.abs(position - exit) > Math.abs(position - exits.get(j))) {
                        exit = exits.get(j);
                    } else if (Math.abs(position - exit) == Math.abs(position - exits.get(j)) && exits.get(j) < exit) {
                        exit = exits.get(j);
                    }
                }
                System.out.println(exit);
            } else {
                ArrayList<Integer> exits = fireExits[position];
                System.out.println(exits.size()-1);
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