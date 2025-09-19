package CCC;

import java.io.*;
import java.util.*;

public class MockCCCS2022 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        String s = readLine();
        int q = readInt();
        for (int i = 0; i < q; i++) {
            String[] input = readLine().split(" ");
            String find = input[0];
            int num = Integer.parseInt(input[1]);
            ArrayList<Integer> aList = new ArrayList();
            int number = 0;
            for (int j = 0; j < num; j++) {
                int index = s.indexOf(find, number);
                if (index == -1) {
                    aList.add(-1);
                    break;
                }
                aList.add(index);
                number = index+1;
            }
            if (aList.get(aList.size()-1) == -1) {
                System.out.println(-1);
            } else
                System.out.println(aList.get(aList.size()-1)+1);
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