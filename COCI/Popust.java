package COCI;

import java.util.*;
import java.io.*;

public class Popust {
    public static void main (String[] args) throws IOException {
        int n = readInt();
        int[][] pair = new int[n][2];
        TreeMap<Integer, Integer> smallestA = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int a = readInt(), b = readInt();
            pair[i][0] = a;
            pair[i][1] = b;
        }
        Arrays.sort(pair, (x, y) -> Integer.compare(x[1], y[1]));
        for (int i = 0; i < n; i++) {
            smallestA.put(pair[i][0], i);
        }

        System.out.println(smallestA.higherKey(-1));
        long sum = 0;

        int dif = Integer.MIN_VALUE;

        for (int i = 0; i < n - 1; i++) {
            sum += pair[i][1]; // sum of b's

            if (smallestA.containsKey(pair[i][0]) && smallestA.get(pair[i][0]) == i) { // a's are equal + indexes are equal
                smallestA.remove(pair[i][0]);
            }

            dif = Math.max(dif, pair[i][1] - pair[i][0]);
            //
            long ans = sum + smallestA.higherKey(-1);

            ans = Math.min(ans, sum + pair[i + 1][1] + Math.min(-dif, -pair[i + 1][1] + pair[i + 1][0]));
            System.out.println(ans);
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
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