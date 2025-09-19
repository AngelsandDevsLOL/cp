package AlphaStar;

import java.io.*;
import java.util.*;

public class SleepingGremlins {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int n = readInt(), k = readInt(), b = readInt();
        int[] goblin = new int[n + 2];
        for (int i = 0; i < b; i++) {
            goblin[readInt()]++;
        }
        int sum = 0;
        for (int i = 1; i <= k; i++) {
            sum += goblin[i];
        }
        int ans = sum; // min !
        for (int i = k + 1; i <= n; i++) {
            sum += goblin[i] - goblin[i - k];
            ans = Math.min(ans, sum);
        }
        System.out.println(ans);
    }

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
