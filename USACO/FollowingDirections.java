package USACO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FollowingDirections {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main (String[] args) throws IOException {
        int n = readInt();
        char[][] directions = new char[n][n];
        int[][] count = new int[n + 1][n + 1];
        for (int[] rows : count) {
            Arrays.fill(rows, 1);
        }
        for (int i = 0; i < n; i++) {
            String[] input = readLine().split(" ");
            for (int j = 0; j < n; j++) {
                directions[i][j] = input[0].charAt(j);
            }
            count[i][n] = Integer.parseInt(input[1]);
        }
        for (int i = 0; i < n; i++) {
            count[n][i] = readInt();
        }
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-1; j++) {
                if (directions[i][j] == 'R') {
                    count[i][j+1]+= count[i][j];
                } else {
                    count[i+1][j]+= count[i][j];
                }
            }
        }
        for (int i = 0; i < n - 1; i++) {
            if (directions[i][n - 1] == 'D') {
                count[i + 1][n - 1] += count[i][n - 1];
            }
            if (directions[n - 1][i] == 'R') {
                count[n - 1][i + 1] += count[n - 1][i];
            }
        }
        long sum = calculate(count, directions, n);
        System.out.println(sum);
        int q = readInt();
        for (int i = 0; i < q; i++) {
            int x = readInt() - 1, y = readInt() - 1;
            recursion(count, directions, n, x, y, count[x][y]);
            if (directions[x][y] == 'R') {
                directions[x][y] = 'D';
            } else directions[x][y] = 'R';
            recursion(count, directions, n, x, y, -count[x][y]);
            System.out.println(calculate(count, directions, n));
        }
    }
    public static void recursion (int[][] count, char[][] directions, int n, int x, int y, int value) {
        if (x == n - 1 && y == n - 1) return;
        if (x == n - 1) {
            if (directions[x][y] == 'R') {
                count[x][y + 1] -= value;
                recursion(count, directions, n, x, y + 1, value);
            }
        } else if (y == n - 1) {
            if (directions[x][y] == 'D') {
                count[x + 1][y] -= value;
                recursion(count, directions, n, x + 1, y, value);
            }
        } else {
            if (directions[x][y] == 'R') {
                count[x][y + 1] -= value;
                recursion(count, directions, n, x, y + 1, value);
            } else if (directions[x][y] == 'D') {
                count[x + 1][y] -= value;
                recursion(count, directions, n, x + 1, y, value);
            }
        }
    }
    public static long calculate (int[][] count, char[][] directions, int n) {
        long sum = 0;
        for (int i = 0; i < n - 1; i++) {
            if (directions[i][n - 1] == 'R') {
                sum += (long) count[i][n] * count[i][n - 1];
            }
            if (directions[n - 1][i] == 'D') {
                sum += (long) count[n - 1][i] * count[n][i];
            }
        }
        if (directions[n - 1][n - 1] == 'R') {
            sum += (long) count[n - 1][n - 1] * count[n - 1][n];
        } else {
            sum += (long) count[n - 1][n - 1] * count[n][n - 1];
        }
        return sum;
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
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}
