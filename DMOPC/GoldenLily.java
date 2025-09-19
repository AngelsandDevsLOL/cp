package DMOPC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class GoldenLily {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int d = readInt(), l = readInt();
        int[][] ar = new int[l][d];
        int[][] dis = new int[l][d];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < d; j++) {
                int input = readInt();
                ar[i][j] = input;
            }
        }
        dis[0][0] = ar[0][0];
        for (int i = 1; i < d; i++) {
            dis[0][i] = dis[0][i - 1] + ar[0][i];
        }
        for (int i = 1; i < l; i++) {
            for (int j = 0; j < d; j++) {
                int sum = ar[i][j] + dis[i - 1][j];
                if (dis[i][j] == 0 || dis[i][j] > sum) {
                    dis[i][j] = sum;
                    for (int k = j - 1; k >= 0; k--) { // slide to the left
                        if (dis[i][k] != 0 && dis[i][k] <= sum + ar[i][k]) break;
                        else {
                            sum += ar[i][k];
                            dis[i][k] = sum;
                        }
                    }
                    sum = dis[i][j];
                    for (int k = j + 1; k < d; k++) { // slide to the right
                        if (dis[i][k] != 0 && dis[i][k] <= sum + ar[i][k]) break;
                        else {
                            sum += ar[i][k];
                            dis[i][k] = sum;
                        }
                    }
                }
            }
        }
        int x = readInt(), y = readInt();
        System.out.println(dis[y][x]);
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
}