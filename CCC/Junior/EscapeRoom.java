package CCC.Junior;

import java.io.*;
import java.util.*;

public class EscapeRoom {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int a = readInt();
        int b = readInt();
        int[][] ar = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                ar[i][j] = readInt();
            }
        }
        Pair pair = new Pair(1, 1);
        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[a][b];
        q.add(pair);
        vis[0][0] = true;
        while (!q.isEmpty()) {
            Pair x = q.poll();
            int y = ar[x.getX() - 1][x.getY() - 1];
            if (vis[a-1][b-1]) {
                break;
            }
            for (int i = 1; i < y; i++) {
                if (y % i == 0) {
                    if (i <= a && y / i <= b && !vis[i - 1][y / i - 1]) {
                        q.add(new Pair(i, y / i));
                        vis[i-1][y/i-1] = true;
                    }
                    if (y / i <= a && i <= b && !vis[y / i - 1][i - 1]) {
                        q.add(new Pair(y / i, i));
                        vis[y/i-1][i-1] = true;
                    }
                }
            }
        }
        if (vis[a-1][b-1]) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
    static class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        int getX() {
            return x;
        }
        int getY() {
            return y;
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