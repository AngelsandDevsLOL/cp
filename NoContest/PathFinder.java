package NoContest;

import java.util.*;
import java.io.*;

public class PathFinder {
    public static boolean[][] ar;
    public static void main (String[] args) throws IOException {
        ar = new boolean[readInt()][readInt()];
        int k = readInt();
        for (int i = 0; i < k; i++) {
            ar[readInt() - 1][readInt() - 1] = true;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(0); q.add(0);
        while (!q.isEmpty()) {
            int x = q.poll(), y = q.poll();
            if (x + 1 < ar.length && !ar[x + 1][y]) {
                ar[x + 1][y] = true;
                q.add(x + 1); q.add(y);
            }
            if (x - 1 >= 0 && !ar[x - 1][y]) {
                ar[x - 1][y] = true;
                q.add(x - 1); q.add(y);
            }
            if (y + 1 < ar[0].length && !ar[x][y + 1]) {
                ar[x][y + 1] = true;
                q.add(x); q.add(y + 1);
            }
            if (y - 1 >= 0 && !ar[x][y - 1]) {
                ar[x][y - 1] = true;
                q.add(x); q.add(y - 1);
            }

        }
        if (ar[ar.length - 1][ar[0].length - 1]) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
    public static boolean check (int x, int y) {
        if (x >= 0 && y >= 0 && x < ar.length && y < ar[0].length) return true;
        return false;
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