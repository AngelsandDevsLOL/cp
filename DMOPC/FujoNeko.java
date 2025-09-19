package DMOPC;

import java.io.*;
import java.util.*;

public class FujoNeko {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int row = readInt();
        int column = readInt();
        HashSet<Integer> col = new HashSet();
        HashSet<Integer> r = new HashSet<>();
        for (int i = 0; i < row; i++) {
            String input = readLine();
            for (int j = 0; j < column; j++) {
                if (input.substring(j,j+1).equals("X")) {
                    col.add(j+1);
                    r.add(i+1);
                }
            }
        }
        int q = readInt();
        for (int i = 0; i < q; i++) {
            boolean bool = false;
            int x = readInt();
            int y = readInt();
            if (col.contains(x)) {
                bool = true;
            }
            if (r.contains(y)) {
                bool = true;
            }
            if (bool) {
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

