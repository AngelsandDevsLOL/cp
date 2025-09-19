package Random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Square {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main (String[] args) throws IOException {
        int n = readInt();
        int[][] ar = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ar[i][j] = readInt();
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (ar[i][j] == 1) {
                    int smallest = Math.min(Math.min(ar[i + 1][j], ar[i][j + 1]), ar[i + 1][j + 1]);
                    ar[i][j] = smallest + 1;
                }
            }
        }
        int max = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ar[i][j] > max) {
                    max = ar[i][j]; count = 1;
                } else if (ar[i][j] == max) {
                    count++;
                }
            }
        }
        System.out.println(max * count);
    }
    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
}
