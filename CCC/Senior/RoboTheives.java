package CCC.Senior;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RoboTheives {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        sc.nextLine();
        int[][] ar = new int[n][m];
        int[][] dis = new int[n][m];
        Pair start = null;
        ArrayList<Pair> cams = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            for (int j = 0; j < m; j++) {
                dis[i][j] = -1;
                if (input.charAt(j) == 'W') {
                    ar[i][j] = -1;
                } else if (input.charAt(j) == 'C') {
                    cams.add(new Pair(i, j));
                } else if (input.charAt(j) == 'S') {
                    start = new Pair(i, j);
                } else if (input.charAt(j) == 'L') {
                    ar[i][j] = 1;
                } else if (input.charAt(j) == 'R') {
                    ar[i][j] = 2;
                } else if (input.charAt(j) == 'U') {
                    ar[i][j] = 3;
                } else if (input.charAt(j) == 'D') {
                    ar[i][j] = 4;
                }
            }
        }
        dis[start.x][start.y] = 0;
        for (Pair p : cams) {
            int x = p.x;
            int y = p.y;
            for (int i = x + 1; i < n; i++) {
                if (ar[i][y] == -1) break;
                if (ar[i][y] == 0) {
                    ar[i][y] = -2;
                }
            }
            for (int i = x - 1; i >= 0; i--) {
                if (ar[i][y] == -1) break;
                if (ar[i][y] == 0) {
                    ar[i][y] = -2;
                }
            }
            for (int i = y + 1; i < m; i++) {
                if (ar[x][i] == -1) break;
                if (ar[x][i] == 0) {
                    ar[x][i] = -2;
                }
            }
            for (int i = y - 1; i >= 0; i--) {
                if (ar[x][i] == -1) break;
                if (ar[x][i] == 0) {
                    ar[x][i] = -2;
                }
            }
            ar[x][y] = -1;
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int x = p.x, y = p.y;
            if (ar[x][y] < 0) {
                continue;
            } else if (ar[x][y] == 0) {
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (i != j && (i == 0 || j == 0) && check(x + i, y + j, n, m) && (dis[x + i][y + j] > dis[x][y] + 1 || dis[x + i][y + j] == -1)) {
                            if (ar[x + i][y + j] < 0) continue;
                            q.add(new Pair(x + i, y + j));
                            dis[x + i][y + j] = dis[x][y] + 1;
                        }
                    }
                }
            } else if (ar[x][y] == 1) {
                if (check(x, y - 1, n, m) && ar[x][y - 1] >= 0 && (dis[x][y - 1] > dis[x][y] || dis[x][y - 1] == -1)) {
                    q.add(new Pair(x, y - 1));
                    dis[x][y - 1] = dis[x][y];
                }
            } else if (ar[x][y] == 2) {
                if (check(x, y + 1, n, m) && ar[x][y + 1] >= 0 && (dis[x][y + 1] > dis[x][y] || dis[x][y + 1] == -1)) {
                    q.add(new Pair(x, y + 1));
                    dis[x][y + 1] = dis[x][y];
                }
            } else if (ar[x][y] == 3) {
                if (check(x - 1, y, n, m) && ar[x - 1][y] >= 0 && (dis[x - 1][y] > dis[x][y] || dis[x - 1][y] == -1)) {
                    q.add(new Pair(x - 1, y));
                    dis[x - 1][y] = dis[x][y];
                }
            } else if (ar[x][y] == 4) {
                if (check(x + 1, y, n, m) && ar[x + 1][y] >= 0 && (dis[x + 1][y] > dis[x][y] || dis[x + 1][y] == -1)) {
                    q.add(new Pair(x + 1, y));
                    dis[x + 1][y] = dis[x][y];
                }
            }
        }
        ar[start.x][start.y] = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ar[i][j] == -2) {
                    System.out.println(-1);
                } else if (ar[i][j] == 0) {
                    System.out.println(dis[i][j]);
                }
            }
        }
    }
    public static boolean check (int x, int y, int n, int m) {
        if (x < n && x >= 0 && y < m && y >= 0) return true;
        return false;
    }
    static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
