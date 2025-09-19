package WLMOJ;

import java.io.*;
import java.util.*;

public class TheLegendOfDaybreak {
    public static void main (String[] args) throws IOException {
        for (int i = 4; i <= 10; i++) {
            File f = new File(i + ".in");
            if (!f.exists()) {
                f.createNewFile();
            } else {
                //
            }
            File f2 = new File(i + ".out");
            if (!f2.exists()) {
                f2.createNewFile();
            } else {
                //
            }
            input(i);
        }
    }
    public static void input(int ca) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(ca + ".in"));
        PrintWriter out2 = new PrintWriter(new FileWriter(ca + ".out"));
        int n = (int) (Math.random() * (1000 - 1)) + 2;
        int m = (int) (Math.random() * (1000 - 1)) + 2;
        out.println(n + " " + m);
        int testx = (int) (Math.random() * n);
        int testy = (int) (Math.random() * (m - 1)) + 1;
        char[][] ar = new char[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ar[i], '.');
        }
        ar[testx][testy] = 't';
        ArrayList<Integer> t = new ArrayList<>();
        int[][] dis = new int[n][m];
        dis[n - 1][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 1/10 chance of W, 1/10 chance of T
                if ((i != testx || j != testy) && (i != n - 1 || j != 0)) {
                    int x = (int) (Math.random() * 20);
                    if (x == 0) {
                        ar[i][j] = 'T';
                        dis[i][j] = -1;
                        t.add(i);
                        t.add(j);
                    } else if (x == 1 || x == 2) {
                        ar[i][j] = 'W';
                        dis[i][j] = -1;
                    }
                }
                out.print((char)ar[i][j]);
            }
            out.println();
        }
        while (!t.isEmpty()) {
            int x = t.remove(0);
            int y = t.remove(0);
            for (int i = x + 1; i < n; i++) {
                if (dis[i][y] == -1) {
                    break;
                }
                dis[i][y] = -1;
            }
            for (int i = y + 1; i < m; i++) {
                if (dis[x][i] == -1) {
                    break;
                }
                dis[x][i] = -1;
            }
            for (int i = x - 1; i >= 0; i--) {
                if (dis[i][y] == -1) {
                    break;
                }
                dis[i][y] = -1;
            }
            for (int i = y - 1; i >= 0; i--) {
                if (dis[x][i] == -1) {
                    break;
                }
                dis[x][i] = -1;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(n - 1);
        q.add(0);
        int[][] directions = {{1,0}, {0, 1}, {-1, 0}, {0, -1}};
        if (dis[n - 1][0] == -1) {
            out2.println(-1);
            out.close();
            out2.close();
            return;
        }
        while (!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();
            for (int i = 0; i < 4; i++) {
                if (check(x + directions[i][0], y + directions[i][1], n, m)) {
                    if (dis[x + directions[i][0]][y + directions[i][1]] == 0) {
                        dis[x + directions[i][0]][y + directions[i][1]] = dis[x][y] + 1;
                        q.add(x + directions[i][0]);
                        q.add(y + directions[i][1]);
                    }
                }
            }
        }
        out2.println((dis[testx][testy] == 0 || dis[testx][testy] == -1) ? -1 : (dis[testx][testy] - 1) * 2 + 1);
        out.close();
        out2.close();
    }
    public static boolean check(int x, int y, int n, int m){
        if (x >= 0 && y >= 0 && x < n && y < m) return true;
        return false;
    }
}
