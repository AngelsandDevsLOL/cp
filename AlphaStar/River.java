package AlphaStar;

import java.util.*;
import java.io.*;

public class River {
    public static void main (String[] args) throws IOException {
        int n = readInt();
        HashMap<Integer, Integer>[] aLi = new HashMap[58];
        for (int i = 0; i < 58; i++) {
            aLi[i] = new HashMap<>();
        }
        for (int i = 0; i < n; i++) {
            String[] input = readLine().split(" ");
            int first = input[0].charAt(0) - 'A';
            int second = input[1].charAt(0) - 'A';
            int val = Integer.parseInt(input[2]);
            if (aLi[first].containsKey(second)) aLi[first].put(second, aLi[first].get(second) + val);
            else aLi[first].put(second, val);
        }
        System.out.println(recursion(0, aLi, new boolean[58]));
    }
    public static int recursion (int node, HashMap<Integer, Integer>[] aList, boolean[] visit) {
        if (node == 25) return Integer.MAX_VALUE;
        int sum = 0;
        for (int i : aList[node].keySet()) {
            if (visit[i]) continue;
            visit[i] = true;
            int num = Math.min(aList[node].get(i), recursion(i, aList, visit));
            if (num > 0) sum += num;
            visit[i] = false;
        }
        if (sum != 0) return sum;
        return -Integer.MAX_VALUE;
    }
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
}
