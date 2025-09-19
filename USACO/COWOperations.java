package USACO;

import java.util.*;
import java.io.*;

public class COWOperations {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        String s = readLine();
        int q = readInt();
        for (int i = 0; i < q; i++) {
            int l = readInt()-1;
            int r = readInt();
            String string = s.substring(l, r);
            while (string.contains("OW") || string.contains("WO")) {
                if (string.contains("OW")) {
                    ArrayList<Integer> aList = new ArrayList();
                    int index = string.indexOf("OW");
                    while (index != -1) {
                        aList.add(index);
                        index = string.indexOf("OW", index + 1);
                    }
                    Collections.sort(aList);
                    for (int j = aList.size() - 1; j >= 0; j--) {
                        index = aList.get(j);
                        string = string.substring(0, index) + "C" + string.substring(index+2);
                    }
                }
                if (string.contains("WO")) {
                    ArrayList<Integer> aList = new ArrayList();
                    int index = string.indexOf("WO");
                    while (index != -1) {
                        aList.add(index);
                        index = string.indexOf("WO", index + 1);
                    }
                    Collections.sort(aList);
                    for (int j = aList.size() - 1; j >= 0; j--) {
                        index = aList.get(j);
                        string = string.substring(0, index) + "C" + string.substring(index+2);
                    }
                }
            }
            if (string.contains("O") || string.contains("W")) {
                System.out.print("N");
            } else {
                if (string.length() % 2 == 0) {
                    System.out.print("N");
                } else {
                    System.out.print("Y");
                }
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
