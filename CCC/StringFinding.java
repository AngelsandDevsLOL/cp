package CCC;

import java.util.*;
import java.io.*;
public class StringFinding {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = readInt();
        int sz = 1000;
        int[][] grid = new int[sz+4][sz+4], dif = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean[][] cow = new boolean[sz+4][sz+4];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int x = readInt() + 1;
            int y = readInt() + 1;
            cow[x][y] = true;
            for (int j = 0; j < 4; j++) {
                int nx = x + dif[j][0], ny = y + dif[j][1];
                grid[nx][ny]++;
                if (grid[nx][ny] == 3 && cow[nx][ny]){
                    ans++;
                } if (grid[nx][ny] == 4 && cow[nx][ny]){
                    ans--;
                }
            }
            System.out.println(ans);
        }
    }
    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(readLine());
        return st.nextToken();
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static int[] convert (String[] in) {
        int[] out = new int[in.length - 1];
        for (int i = 1; i < in.length; i++) out[i - 1] = Integer.parseInt(in[i]);
        return out;
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