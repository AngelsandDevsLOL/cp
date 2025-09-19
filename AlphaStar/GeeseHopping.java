package AlphaStar;

import java.io.*;
import java.util.*;

public class GeeseHopping {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int m = readInt(), n = readInt();
        int[][] val = new int[m][n];
        int startX = 0, startY = 0;
        int endX = 0, endY = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int input = readInt();
                if (input == 0) val[i][j] = 1;
                else if (input == 2) val[i][j] = -1;
                else if (input == 3) {
                    startX = i;
                    startY = j;
                } else if (input == 4) {
                    endX = i;
                    endY = j;
                }
            }
        }
        int minGoose = Integer.MAX_VALUE;
        int minJumps = Integer.MAX_VALUE;
        int count = 1;
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(0, 0, startX, startY));
        int[][] directions = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}}; // 8
        boolean[][] vis = new boolean[m][n];
        vis[startX][startY] = true;
        while (!q.isEmpty()) {
            int geese = q.peek().a;
            Queue<Integer> visited = new LinkedList<>();
            Queue<Pair> temp = new LinkedList<>();
            while (!q.isEmpty() && q.peek().a == geese) {
                temp.add(q.poll());
            }
            for (Pair p : temp) {
                if (p.x == endX && p.y == endY) {
                    if (minGoose > p.a) {
                        minGoose = p.a;
                        minJumps = p.b;
                        count = 1;
                    } else if (minGoose == p.a) {
                        if (minJumps > p.b) {
                            minJumps = p.b;
                            count = 1;
                        } else if (minJumps == p.b) count++;
                    }
                    continue;
                }
                for (int i = 0; i < 8; i++) {
                    int nextX = p.x + directions[i][0];
                    int nextY = p.y + directions[i][1];
                    if (check(nextX, nextY, m, n) && !vis[nextX][nextY] && val[nextX][nextY] != -1) {
                        q.add(new Pair(p.a + val[nextX][nextY], p.b + 1, nextX, nextY));
                        visited.add(nextX);
                        visited.add(nextY);
                    }
                }
            }
            while (visited.size() != 0) {
                vis[visited.poll()][visited.poll()] = true;
            }
        }
        if (minGoose == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(minGoose);
        System.out.println(minJumps);
        System.out.println(count);
    }
    public static class Pair implements Comparable {
        int a; // # of geese needed
        int b; // # of jumps needed
        int x;
        int y;

        public Pair(int aa, int bb, int xx, int yy) {
            x = xx;
            y = yy;
            a = aa; b = bb;
        }

        @Override
        public int compareTo(Object o) {
            if (a == ((Pair)o).a) {
                Integer.compare(b, ((Pair)o).b);
            }
            return Integer.compare(a, ((Pair)o).a);
        }
    }
    public static boolean check (int x, int y, int m, int n) {
        if (x >= 0 && y >= 0 && x < m && y < n) return true;
        return false;
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
