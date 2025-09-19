package Random;

import java.util.*;
import java.io.*;

public class YieldingtheLongestSubstring {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static String next () throws IOException {
        while (st == null || ! st.hasMoreTokens())
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
    public static void main (String[] args) throws IOException {
        int t = readInt();
        for (int i = 0; i < t; i++) {
            int n = readInt();
            ArrayList<int[]> aList = new ArrayList<int[]>();
            String input = readLine();
            char prev = 0;
            int count = 1;
            int max = 0;
            for (int j = 0; j < n; j++) {
                if (prev == 0) {
                    prev = input.charAt(j);
                } else if (prev == input.charAt(j)) {
                    count++;
                } else {
                    aList.add(new int[]{prev, count});
                    prev = input.charAt(j);
                    max = Math.max(max, count);
                    count = 1;
                }
            }
            aList.add(new int[]{prev, count});
            max = Math.max(max, count);
            for (int j = 0; j < aList.size() - 2; j++) {
                if (aList.get(j)[0] == aList.get(j + 2)[0] && aList.get(j + 1)[1] == 1) {
                    max = Math.max(max, aList.get(j)[1] + aList.get(j + 2)[1]);
                }
            }
            System.out.println(aList.size() == 1 ? max : max + 1);
        }
    }
}
