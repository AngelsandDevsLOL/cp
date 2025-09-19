package CCC;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ARangeMaxQueryProblem {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int q = readInt();
        int p = readInt();
        int qi = 0;
        int ai = 0;
        ArrayList<Integer> aList = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            String[] input = readLine().split(" ");
            if (input[0].equals("A")) {
                int num = Integer.parseInt(input[1]) ^ ai;
                ai = Integer.parseInt(input[1]);
                aList.add(num);
            } else {
                int number = Integer.parseInt(input[1]) ^ qi;
                qi = Integer.parseInt(input[1]);
                int index = number;
                int count = 0;
                for (int j = 0; j < index; j++) {
                    int num = aList.get(aList.size()-j-1);
                    if (num > count) {
                        count = num;
                    }
                }
                System.out.println(count);
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