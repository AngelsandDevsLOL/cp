package AlphaStar;

import java.io.*;
import java.util.*;

public class ArcadeDay {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static int ans = Integer.MAX_VALUE;
    public static int[] ar;
    public static void main(String[] args) throws IOException{
        ar = new int[12];
        for (int i = 0; i < 12; i++) {
            ar[i] = readInt();
        }
        method(0, new int[]{3, 3, 3, 3}, new int[4]);
        System.out.println(ans);
    }
    public static void method (int ind, int[] teamSize, int[] sums) {
        if (ind == 12) {
            int max = Math.max(Math.max(Math.max(sums[0], sums[1]), sums[2]), sums[3]);
            int min = Math.min(Math.min(Math.min(sums[0], sums[1]), sums[2]), sums[3]);
            ans = Math.min(ans, max - min);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (teamSize[i] != 0) {
                teamSize[i]--;
                sums[i] += ar[ind];
                method(ind + 1, teamSize, sums);
                teamSize[i]++;
                sums[i] -= ar[ind];
            }
        }
    }
    static String next () throws IOException {
        while (st == null || ! st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
}
