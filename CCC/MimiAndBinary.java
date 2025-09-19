package CCC;

import java.util.*;
import java.io.*;

public class MimiAndBinary {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        String s = readLine();
        int q = readInt();
        for (int i = 0; i < q; i++) {
            int x = readInt();
            int y = readInt();
            int z = readInt();
            int count = 0;
            ArrayList<Integer> aList = new ArrayList();
            while (aList.size() < y) {
                int index = s.indexOf(String.valueOf(z), x-1);
                if (index == -1) {
                    count = -1;
                    break;
                } else {
                    x = index+2;
                    aList.add(index);
                    count = index+1;
                }
            }
            System.out.println(count);
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